package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Document;
import by.vsu.emdsproject.model.DocumentInfo;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.DocumentInfoService;
import by.vsu.emdsproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Max
 */
@Controller
@RequestMapping("/teacher/documents")
public class DocumentsController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DocumentInfoService documentInfoService;

    @RequestMapping(value = "/statement")
    private ModelAndView addStatement(String id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ModelAndView modelAndView = new ModelAndView("teacher/documents/statement");
        modelAndView.addObject("abiturient", studentService.read(Long.parseLong(id)));
        modelAndView.addObject("currentDate", sdf.format(new Date()));
        return modelAndView;
    }

    @RequestMapping(value = "/statement", method = RequestMethod.POST)
    private String doAddStatement(String id, String commentary) {
        Student abiturient = studentService.read(Long.parseLong(id));
        DocumentInfo statement = abiturient.getDocuments().get(Document.STATEMENT);
        statement.setBrought(true);
        statement.setCommentary(commentary);
        studentService.update(abiturient);
        return "/teacher/abiturients";
    }

}
