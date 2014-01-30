package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.GroupDAO;
import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.dao.TeacherDAO;
import by.vsu.emdsproject.report.aspose.generator.AsposeDocxReportGenerator;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.ExamStatementDS;
import by.vsu.emdsproject.report.datasource.PersonCardDS;
import com.aspose.words.Document;
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

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    TeacherDAO teacherDAO;

    @Autowired
    GroupDAO groupDAO;

    @Autowired
    AsposeDocxReportGenerator generator;

    public static final Map<String, String> fileNameMap = new HashMap();
    public static final Map<String, Document> documentMap = new HashMap();

    @RequestMapping(value = "/personCard", method = RequestMethod.POST)
    public
    @ResponseBody
    String personCard(String student, boolean printPhoto, HttpServletResponse response) {
        PersonCardDS dataSource = new PersonCardDS();
        Map map = new HashMap();
        map.put(PersonCardDS.DataSourceParameter.STUDENT, student);
        map.put(PersonCardDS.ReportParameter.WITH_PHOTO, printPhoto);
        dataSource.init(map);
        Document document = generator.generate(dataSource);
        String filename = generateFileName(dataSource);
        response.setStatus(HttpServletResponse.SC_OK);
        return putDocument(document, filename);
    }

    @RequestMapping(value = "/examStatement", method = RequestMethod.POST)
    public
    @ResponseBody
    String examStatement(@RequestBody String stringData, HttpServletResponse response) {
        DBObject data = (DBObject) JSON.parse(stringData);
        Map map = new HashMap();
        map.put(ExamStatementDS.DataSourceParameter.GROUP, data.get("group"));
        map.put(ExamStatementDS.ReportParameter.TEACHERS_FIO, data.get("teachers"));
        ExamStatementDS dataSource = new ExamStatementDS();
        dataSource.init(map);
        Document document = generator.generate(dataSource);
        String filename = generateFileName(dataSource);
        response.setStatus(HttpServletResponse.SC_OK);
        return putDocument(document, filename);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getFile(String fileCode, HttpServletResponse response) throws Exception {
        String fileName = fileNameMap.remove(fileCode);
        Document document = documentMap.remove(fileName);
        String header = CONTENT_HEADER + urlEncode(fileName);
        response.setHeader(CONTENT_DESCRIPTION, header);
        generator.exportDocumentInServlet(document, response);
    }

    private String generateFileName(AbstractReportDataSource dataSource) {
        return dataSource.getTitle() + ".docx";
    }

    private String urlEncode(String str) throws UnsupportedEncodingException {
        String result = URLEncoder.encode(str, "UTF-8");
        result = result.replace("+", "%20");
        return result;
    }

    private String putDocument(Document document, String filename) {
        documentMap.put(filename, document);
        String key = String.valueOf(System.currentTimeMillis());
        fileNameMap.put(key, filename);
        return key;
    }
}