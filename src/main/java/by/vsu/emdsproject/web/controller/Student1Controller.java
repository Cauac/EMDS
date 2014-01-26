package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.ArchiveDAO;
import by.vsu.emdsproject.dao.StudentDAO;
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
    StudentDAO studentDAO;

    @Autowired
    ArchiveDAO archiveDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    BasicDBList getAll() {
        return studentDAO.readAll(StudentDAO.STUDENT1);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody String studentJSON, HttpServletResponse response) {
        DBObject student = (DBObject) JSON.parse(studentJSON);
        studentDAO.save(student);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/archive", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id, HttpServletResponse response) {
        archiveDAO.save(studentDAO.read(id));
        studentDAO.delete(id, StudentDAO.STUDENT1);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/promote", method = RequestMethod.POST)
    public void promote(@RequestBody String stringData, HttpServletResponse response) {
        DBObject data = (DBObject) JSON.parse(stringData);
        String studentId = data.get("id").toString();
        String groupId = data.get("group_id").toString();
        studentDAO.promote(studentId, groupId);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
