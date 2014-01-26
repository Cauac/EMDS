package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.GroupDAO;
import by.vsu.emdsproject.dao.StudentDAO;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "group")
public class GroupController {

    @Autowired
    GroupDAO groupDAO;

    @Autowired
    StudentDAO studentDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    BasicDBList getAll() {
        return groupDAO.readAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody String groupJSON, HttpServletResponse response) {
        DBObject group = (DBObject) JSON.parse(groupJSON);
        groupDAO.save(group);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id, HttpServletResponse response) {
        groupDAO.delete(id);
        response.setStatus(HttpServletResponse.SC_OK);
        //TODO пройтись по всем студентам, удалить связь
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody String groupJSON, HttpServletResponse response) {
        DBObject group = (DBObject) JSON.parse(groupJSON);
        groupDAO.delete(group.get("id").toString());
        groupDAO.save((DBObject) group.get("data"));
        response.setStatus(HttpServletResponse.SC_OK);
        //TODO пройтись по всем студентам, обновить связь
    }

    @RequestMapping(value = "/getStudents", method = RequestMethod.POST)
    public
    @ResponseBody
    BasicDBList getStudents(@RequestBody String groupId) {
        return studentDAO.readByGroup(groupId);
    }
}
