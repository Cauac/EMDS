package by.vsu.emdsproject.web.controller;

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
@RequestMapping("/archive")
public class ArchiveController {


    @Autowired
    ArchiveDAO archiveDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    BasicDBList getAll() {
        return archiveDAO.readAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id, HttpServletResponse response) {
        archiveDAO.delete(id);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody String studentJSON, HttpServletResponse response) {
        DBObject student = (DBObject) JSON.parse(studentJSON);
        archiveDAO.save(student);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
