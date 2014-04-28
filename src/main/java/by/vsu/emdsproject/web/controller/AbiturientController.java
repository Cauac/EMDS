package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.AbiturientDAO;
import by.vsu.emdsproject.dao.ArchiveDAO;
import by.vsu.emdsproject.dao.StudentDAO;
import com.aspose.words.*;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/abiturient")
public class AbiturientController {


    @Autowired
    AbiturientDAO abiturientDAO;

    @Autowired
    ArchiveDAO archiveDAO;

    @Autowired
    StudentDAO studentDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public
    @ResponseBody
    DBObject getAll(@RequestBody String jsonOptions) {
        DBObject options = (DBObject) JSON.parse(jsonOptions);
        int page = (int) options.get("page");
        String faculty = options.get("faculty").toString();
        return abiturientDAO.getAbiturients(page, 6, faculty);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public
    @ResponseBody
    DBObject save(@RequestBody String studentJSON, HttpServletResponse response) {
        DBObject student = (DBObject) JSON.parse(studentJSON);
        abiturientDAO.insert(student);
        response.setStatus(HttpServletResponse.SC_OK);
        return student;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public
    @ResponseBody
    DBObject update(@RequestBody String studentJSON, HttpServletResponse response) {
        DBObject student = (DBObject) JSON.parse(studentJSON);
        abiturientDAO.update(student);
        response.setStatus(HttpServletResponse.SC_OK);
        return student;
    }

    @RequestMapping(value = "/archive", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id, HttpServletResponse response) {
        archiveDAO.save(abiturientDAO.read(id), "Не принят");
        abiturientDAO.delete(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/studentialize", method = RequestMethod.POST)
    public void studentialize(@RequestBody String stringData, HttpServletResponse response) {
        DBObject data = (DBObject) JSON.parse(stringData);
        String studentId = data.get("id").toString();
        String groupId = data.get("group_id").toString();
        studentDAO.addStudent(abiturientDAO.read(studentId), groupId);
        abiturientDAO.delete(studentId);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/saveDocument", method = RequestMethod.POST)
    public void saveDocument(@RequestBody String stringData, HttpServletResponse response) {
        DBObject data = (DBObject) JSON.parse(stringData);
        String studentId = data.get("id").toString();
        String documentType = data.get("documentType").toString();
        abiturientDAO.saveDocument(studentId, documentType, (DBObject) data.get("data"));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/saveQuestionnaire", method = RequestMethod.POST)
    public void saveQuestionnaire(@RequestBody String stringData, HttpServletResponse response) {
        DBObject data = (DBObject) JSON.parse(stringData);
        String studentId = data.get("id").toString();
        abiturientDAO.saveQuestionnaire(studentId, (DBObject) data.get("data"));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/uploadProgressFile", method = RequestMethod.POST)
    public void uploadProgressFile(@RequestBody String jsonData, HttpServletResponse response) throws Exception {
        DBObject data = (DBObject) JSON.parse(jsonData);
        String faculty = data.get("faculty").toString();
        String fileInString = data.get("file").toString();
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] fileBytes = decoder.decodeBuffer(fileInString.substring(fileInString.indexOf("base64,") + 7));
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fileBytes);
        try {
            Map<String, String> progressMap = extractStudentProgress(inputStream);
            abiturientDAO.setProgress(progressMap, faculty);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public Map<String, String> extractStudentProgress(InputStream file) throws Exception {
        Map<String, String> result = new HashMap<>();
        Document document = new Document(file);
        Table table = (Table) document.getChild(NodeType.TABLE, 1, true);
        table.getRows().removeAt(0);
        for (Row row : table.getRows()) {
            NodeCollection<Cell> cells = row.getCells();
            String fio = cells.get(1).getFirstParagraph().getText().trim();
            String value = cells.get(2).getFirstParagraph().getText();
            result.put(fio, value);
        }
        return result;
    }
}
