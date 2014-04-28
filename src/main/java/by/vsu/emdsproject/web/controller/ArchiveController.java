package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.ArchiveDAO;
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

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public
    @ResponseBody
    DBObject getAll(@RequestBody String jsonOptions) {
        DBObject options = (DBObject) JSON.parse(jsonOptions);
        int page = (int) options.get("page");
        String faculty = options.get("faculty").toString();
        String status = options.get("status").toString();
        return archiveDAO.readList(page, 10, faculty, status);
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
