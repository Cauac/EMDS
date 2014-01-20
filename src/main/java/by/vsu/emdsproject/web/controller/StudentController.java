package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.Student1DAO;
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
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    Student1DAO student1DAO;

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

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id, HttpServletResponse response) {
        student1DAO.delete(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody String studentJSON, HttpServletResponse response) {
        DBObject student = (DBObject) JSON.parse(studentJSON);
        student1DAO.delete(student.get("id").toString());
        student1DAO.save((DBObject) student.get("data"));
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
