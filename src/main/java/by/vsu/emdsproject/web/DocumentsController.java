package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Document;
import by.vsu.emdsproject.model.DocumentInfo;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.DocumentService;
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
@RequestMapping("/teacher")
public class DocumentsController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/documents/statement")
    private ModelAndView addStatement(String id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ModelAndView modelAndView = new ModelAndView("teacher/documents/statement");
        modelAndView.addObject("abiturient", studentService.read(Long.parseLong(id)));
        modelAndView.addObject("currentDate", sdf.format(new Date()));
        return modelAndView;
    }

    @RequestMapping(value = "/documents/statement", method = RequestMethod.POST)
    private String doAddStatement(String id, String commentary) {
        Document document = documentService.read(Document.STATEMENT);
        Student abiturient = studentService.read(Long.parseLong(id));
        DocumentInfo statementInfo = abiturient.getDocuments().get(document);
        statementInfo.setBrought(true);
        statementInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/teacher/abiturients";
    }

    @RequestMapping(value = "/documents/registration")
    private ModelAndView addRegistration(String id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ModelAndView modelAndView = new ModelAndView("teacher/documents/registration");
        modelAndView.addObject("abiturient", studentService.read(Long.parseLong(id)));
        modelAndView.addObject("currentDate", sdf.format(new Date()));
        return modelAndView;
    }

    @RequestMapping(value = "/documents/registration", method = RequestMethod.POST)
    private String doAddRegistration(String id, String commentary) {
        Document document = documentService.read(Document.REGISTRATION_SERTIFICATE_COPY);
        Student abiturient = studentService.read(Long.parseLong(id));
        DocumentInfo statementInfo = abiturient.getDocuments().get(document);
        statementInfo.setBrought(true);
        statementInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/teacher/abiturients";
    }

    @RequestMapping(value = "/documents/passport")
    private ModelAndView addPassport(String id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ModelAndView modelAndView = new ModelAndView("teacher/documents/passport");
        modelAndView.addObject("abiturient", studentService.read(Long.parseLong(id)));
        modelAndView.addObject("currentDate", sdf.format(new Date()));
        return modelAndView;
    }

    @RequestMapping(value = "/documents/passport", method = RequestMethod.POST)
    private String doAddPassport(String id, String commentary) {
        Document document = documentService.read(Document.PASSPORT_COPY);
        Student abiturient = studentService.read(Long.parseLong(id));
        DocumentInfo statementInfo = abiturient.getDocuments().get(document);
        statementInfo.setBrought(true);
        statementInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/teacher/abiturients";
    }

    @RequestMapping(value = "/documents/characteristic")
    private ModelAndView addCharacteristic(String id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ModelAndView modelAndView = new ModelAndView("teacher/documents/characteristic");
        modelAndView.addObject("abiturient", studentService.read(Long.parseLong(id)));
        modelAndView.addObject("currentDate", sdf.format(new Date()));
        return modelAndView;
    }

    @RequestMapping(value = "/documents/characteristic", method = RequestMethod.POST)
    private String doAddCharacteristic(String id, String commentary) {
        Document document = documentService.read(Document.CHARACTERISTIC);
        Student abiturient = studentService.read(Long.parseLong(id));
        DocumentInfo statementInfo = abiturient.getDocuments().get(document);
        statementInfo.setBrought(true);
        statementInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/teacher/abiturients";
    }

    @RequestMapping(value = "/documents/sertificate")
    private ModelAndView addSertificate(String id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ModelAndView modelAndView = new ModelAndView("teacher/documents/sertificate");
        modelAndView.addObject("abiturient", studentService.read(Long.parseLong(id)));
        modelAndView.addObject("currentDate", sdf.format(new Date()));
        return modelAndView;
    }

    @RequestMapping(value = "/documents/sertificate", method = RequestMethod.POST)
    private String doAddSertificate(String id, String commentary) {
        Document document = documentService.read(Document.COMISSION_SERTIFICATE);
        Student abiturient = studentService.read(Long.parseLong(id));
        DocumentInfo statementInfo = abiturient.getDocuments().get(document);
        statementInfo.setBrought(true);
        statementInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/teacher/abiturients";
    }

    @RequestMapping(value = "/documents/questionnaire")
    private ModelAndView addQuestionnaire(String id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ModelAndView modelAndView = new ModelAndView("teacher/documents/questionnaire");
        modelAndView.addObject("abiturient", studentService.read(Long.parseLong(id)));
        modelAndView.addObject("currentDate", sdf.format(new Date()));
        return modelAndView;
    }

    @RequestMapping(value = "/documents/questionnaire", method = RequestMethod.POST)
    private String doAddQuestionnaire(String id, String commentary) {
        Document document = documentService.read(Document.QUESTIONNAIRE);
        Student abiturient = studentService.read(Long.parseLong(id));
        DocumentInfo statementInfo = abiturient.getDocuments().get(document);
        statementInfo.setBrought(true);
        statementInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/teacher/abiturients";
    }


}
