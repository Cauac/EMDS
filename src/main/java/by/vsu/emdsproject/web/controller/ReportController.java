package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.*;
import by.vsu.emdsproject.report.aspose.generator.AsposeDocxReportGenerator;
import by.vsu.emdsproject.report.datasource.*;
import com.aspose.words.Document;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "report")
public class ReportController {

    public static final String CONTENT_HEADER = "attachment; filename*=UTF-8''";
    public static final String CONTENT_DESCRIPTION = "Content-Disposition";
    public static final Map<String, String> fileNameMap = new HashMap();
    public static final Map<String, Document> documentMap = new HashMap();

    @Autowired
    GroupDAO groupDAO;

    @Autowired
    TeacherDAO teacherDAO;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    SpecialtyDAO specialtyDAO;

    @Autowired
    AbiturientDAO abiturientDAO;

    @Autowired
    AsposeDocxReportGenerator generator;

    @RequestMapping(value = "/personCard", method = RequestMethod.POST)
    public
    @ResponseBody
    String personCard(String studentId, boolean printPhoto, HttpServletResponse response) {
        Map params = new HashMap();
        params.put(PersonCardDS.DataSourceParameter.STUDENT, studentDAO.read(studentId));
        params.put(PersonCardDS.ReportParameter.WITH_PHOTO, printPhoto);
        response.setStatus(HttpServletResponse.SC_OK);
        return generateDocx(new PersonCardDS(), params);
    }

    @RequestMapping(value = "/examStatement", method = RequestMethod.POST)
    public
    @ResponseBody
    String examStatement(@RequestBody String stringData, HttpServletResponse response) {
        DBObject data = (DBObject) JSON.parse(stringData);
        String groupId = (String) data.get("group");
        BasicDBList teachers = (BasicDBList) data.get("teachers");
        Map params = new HashMap();
        params.put(ExamStatementDS.DataSourceParameter.GROUP, groupDAO.read(groupId));
        params.put(ExamStatementDS.DataSourceParameter.TEACHERS, teachers);
        params.put(ExamStatementDS.DataSourceParameter.STUDENTS, studentDAO.readByGroup(groupId));
        params.put(ExamStatementDS.DataSourceParameter.CHIEF, teacherDAO.readChief());
        response.setStatus(HttpServletResponse.SC_OK);
        return generateDocx(new ExamStatementDS(), params);
    }

    @RequestMapping(value = "/examProtocol", method = RequestMethod.POST)
    public
    @ResponseBody
    String examProtocol(@RequestBody String stringData, HttpServletResponse response) {
        DBObject data = (DBObject) JSON.parse(stringData);
        String groupId = (String) data.get("group");
        DBObject members = (DBObject) data.get("members");
        DBObject group = groupDAO.read(groupId);
        String specialtyId = group.get("specialty").toString();
        Map params = new HashMap();
        params.put(ExamProtocolDS.DataSourceParameter.GROUP, group);
        params.put(ExamProtocolDS.DataSourceParameter.MEMBERS, members);
        params.put(ExamProtocolDS.DataSourceParameter.STUDENTS, studentDAO.readByGroup(groupId));
        params.put(ExamProtocolDS.DataSourceParameter.SPECIALTY, specialtyDAO.read(specialtyId));
        response.setStatus(HttpServletResponse.SC_OK);
        return generateDocx(new ExamProtocolDS(), params);
    }

    @RequestMapping(value = "/allowedList", method = RequestMethod.POST)
    public
    @ResponseBody
    String allowedList(@RequestBody String groupId, HttpServletResponse response) {
        DBObject group = groupDAO.read(groupId);
        String specialtyId = group.get("specialty").toString();
        Map params = new HashMap();
        params.put(AllowedListDS.DataSourceParameter.GROUP, group);
        params.put(AllowedListDS.DataSourceParameter.CHIEF, teacherDAO.readChief());
        params.put(AllowedListDS.DataSourceParameter.STUDENTS, studentDAO.readByGroup(groupId));
        params.put(AllowedListDS.DataSourceParameter.SPECIALTY, specialtyDAO.read(specialtyId));
        response.setStatus(HttpServletResponse.SC_OK);
        return generateDocx(new AllowedListDS(), params);
    }

    @RequestMapping(value = "/progressRequest", method = RequestMethod.POST)
    public
    @ResponseBody
    String progressRequest(@RequestBody String faculty, HttpServletResponse response) {
        Map params = new HashMap();
        params.put(ProgressRequestDS.DataSourceParameter.FACULTY_NAME, faculty);
        params.put(ProgressRequestDS.DataSourceParameter.CHIEF, teacherDAO.readChief());
        params.put(ProgressRequestDS.DataSourceParameter.STUDENTS, abiturientDAO.readByFaculty(faculty));
        response.setStatus(HttpServletResponse.SC_OK);
        return generateDocx(new ProgressRequestDS(), params);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getFile(String fileCode, HttpServletResponse response) throws Exception {
        String fileName = fileNameMap.remove(fileCode);
        Document document = documentMap.remove(fileName);
        String header = CONTENT_HEADER + urlEncode(fileName);
        response.setHeader(CONTENT_DESCRIPTION, header);
        generator.exportDocumentInServlet(document, response);
    }

    private String urlEncode(String str) throws UnsupportedEncodingException {
        String result = URLEncoder.encode(str, "UTF-8");
        result = result.replace("+", "%20");
        return result;
    }

    private String generateDocx(AbstractReportDataSource ds, Map params) {
        ds.init(params);
        Document document = generator.generate(ds);
        String filename = ds.getTitle() + ".docx";
        return putDocument(document, filename);
    }

    private String putDocument(Document document, String filename) {
        documentMap.put(filename, document);
        String key = String.valueOf(System.currentTimeMillis());
        fileNameMap.put(key, filename);
        return key;
    }
}