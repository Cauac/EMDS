package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.TeacherDAO;
import by.vsu.emdsproject.common.TeacherComparator;
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
import java.util.Collections;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    TeacherDAO teacherDAO;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    BasicDBList getTeacherList(boolean select, boolean sort) {
        BasicDBList result = select ? teacherDAO.readAllForSelect() : teacherDAO.readAll();
        if (sort) Collections.sort(result, new TeacherComparator());
        return result;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public
    @ResponseBody
    DBObject saveTeacher(@RequestBody String teacherJSON, HttpServletResponse res) {
        DBObject teacher = (DBObject) JSON.parse(teacherJSON);
        teacherDAO.save(teacher);
        res.setStatus(HttpServletResponse.SC_OK);
        return teacher;
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void delete(String id, HttpServletResponse response) {
        teacherDAO.delete(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "chooseChief", method = RequestMethod.POST)
    public void chooseChief(String id, HttpServletResponse response) {
        teacherDAO.chooseChief(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }


}
