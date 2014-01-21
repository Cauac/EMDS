package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.ArchiveDAO;
import by.vsu.emdsproject.dao.Student1DAO;
import by.vsu.emdsproject.dao.Student2DAO;
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
@RequestMapping(value = "student1")
public class Student1Controller {

    @Autowired
    Student1DAO student1DAO;

    @Autowired
    Student2DAO student2DAO;

    @Autowired
    ArchiveDAO archiveDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    BasicDBList getAll() {
        return student1DAO.readAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody String studentJSON, HttpServletResponse response) {
        DBObject student = (DBObject) JSON.parse(studentJSON);
        student1DAO.save(student);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/archive", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id, HttpServletResponse response) {
        archiveDAO.save(student1DAO.read(id));
        student1DAO.delete(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/promote", method = RequestMethod.POST)
    public void promote(@RequestBody String stringData, HttpServletResponse response) {
        DBObject data = (DBObject) JSON.parse(stringData);
        String studentId = data.get("id").toString();
        String groupId = data.get("group_id").toString();
        student1DAO.promote(studentId, groupId);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
