package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.ArchiveDAO;
import by.vsu.emdsproject.dao.StudentDAO;
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
    StudentDAO studentDAO;

    @Autowired
    ArchiveDAO archiveDAO;

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public
    @ResponseBody
    DBObject getAll(@RequestBody String jsonOptions) {
        DBObject options = (DBObject) JSON.parse(jsonOptions);
        int page = (int) options.get("page");
        String faculty = options.get("faculty").toString();
        String group = options.get("group").toString();
        return studentDAO.readList(StudentDAO.STUDENT2, page, 10, faculty, group);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody String studentJSON, HttpServletResponse response) {
        DBObject student = (DBObject) JSON.parse(studentJSON);
        studentDAO.save(student);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/archive", method = RequestMethod.DELETE)
    public void delete(@RequestBody String id, HttpServletResponse response) {
        archiveDAO.save(studentDAO.read(id), "Отчислен");
        studentDAO.delete(id, StudentDAO.STUDENT2);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public void promote(@RequestBody String id, HttpServletResponse response) {
        DBObject student = studentDAO.read(id);
        student.put("rank", "Лейтенант запаса");
        archiveDAO.save(studentDAO.read(id), "Завершившил обучение");
        studentDAO.delete(id, StudentDAO.STUDENT2);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}