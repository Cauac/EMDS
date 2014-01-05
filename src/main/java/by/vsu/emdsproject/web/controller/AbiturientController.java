package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.AbiturientDAO;
import by.vsu.emdsproject.dao.ArchiveDAO;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/abiturient")
public class AbiturientController {


    @Autowired
    AbiturientDAO abiturientDAO;

    @Autowired
    ArchiveDAO archiveDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    BasicDBList getAll() {
        return abiturientDAO.readAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public
    @ResponseBody
    DBObject save(@RequestBody String studentJSON, HttpServletResponse response) {
        DBObject student = (DBObject) JSON.parse(studentJSON);
        abiturientDAO.save(student);
        response.setStatus(HttpServletResponse.SC_OK);
        return student;
    }

    @RequestMapping(value = "/archive", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id, HttpServletResponse response) {
        archiveDAO.save(abiturientDAO.read(id));
        abiturientDAO.delete(id);
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
}
