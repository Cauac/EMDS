package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.dao.SpecialtyDAO;
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
@RequestMapping(value = "specialty")
public class SpecialtyController {

    @Autowired
    SpecialtyDAO specialtyDAO;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    BasicDBList getSpecialties() {
        return specialtyDAO.readAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveSpecialty(@RequestBody String specialtyJSON, HttpServletResponse response) {
        DBObject specialty = (DBObject) JSON.parse(specialtyJSON);
        specialtyDAO.save(specialty);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteSpecialty(@RequestBody String id, HttpServletResponse response) {
        specialtyDAO.delete(id);
        response.setStatus(HttpServletResponse.SC_OK);
        //TODO пройтись по всем группам, удалить связь
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateSpeciality(@RequestBody String specialtyJSON, HttpServletResponse response) {
        DBObject specialty = (DBObject) JSON.parse(specialtyJSON);
        specialtyDAO.delete(specialty.get("id").toString());
        specialtyDAO.save((DBObject) specialty.get("data"));
        response.setStatus(HttpServletResponse.SC_OK);
        //TODO пройтись по всем группам, обновить связь
    }

}
