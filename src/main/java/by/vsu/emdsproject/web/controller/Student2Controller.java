package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.ArchiveDAO;
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
@RequestMapping(value = "student2")
public class Student2Controller {

    @Autowired
    Student2DAO student2DAO;

    @Autowired
    ArchiveDAO archiveDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    BasicDBList getAll() {
        return student2DAO.readAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody String studentJSON, HttpServletResponse response) {
        DBObject student = (DBObject) JSON.parse(studentJSON);
        student2DAO.save(student);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/archive", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id, HttpServletResponse response) {
        archiveDAO.save(student2DAO.read(id));
        student2DAO.delete(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/promote", method = RequestMethod.POST)
    public void promote(@RequestBody String stringData, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
    }
}