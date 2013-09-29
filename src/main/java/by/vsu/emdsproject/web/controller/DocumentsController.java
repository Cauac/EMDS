package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.common.EMDSGlobal;
import by.vsu.emdsproject.model.Document;
import by.vsu.emdsproject.model.DocumentInfo;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.DocumentService;
import by.vsu.emdsproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author Max
 */
@Controller
@RequestMapping("/documents")
public class DocumentsController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DocumentService documentService;

    @ModelAttribute("student")
    public Student setAbiturient(Long id) {
        if (id == null) {
            return new Student();
        } else {
            return studentService.read(id);
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(EMDSGlobal.dateFormat, true));
    }

    /*
     *  Заявление
     */
    @RequestMapping(value = "/statement")
    public ModelAndView addStatement() {
        return new ModelAndView("/documents/statement", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/statement", method = RequestMethod.POST)
    public String doAddStatement(@ModelAttribute("student") Student student, String commentary) {
        Document document = documentService.read(Document.STATEMENT);
        DocumentInfo statementInfo = student.getDocuments().get(document);
        statementInfo.setBrought(true);
        statementInfo.setCommentary(commentary);
        studentService.save(student);
        return "redirect:/abiturients";
    }

    /*
     *  Копия приписного свидетельства
     */
    @RequestMapping(value = "/registration")
    public ModelAndView addRegistration() {
        return new ModelAndView("documents/registration", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String doAddRegistration(@ModelAttribute("student") Student student, String commentary) {
        Document document = documentService.read(Document.REGISTRATION_CERTIFICATE_COPY);
        DocumentInfo registrationInfo = student.getDocuments().get(document);
        registrationInfo.setBrought(true);
        registrationInfo.setCommentary(commentary);
        studentService.save(student);
        return "redirect:/abiturients";
    }

    /*
     *  Копия паспорта
     */
    @RequestMapping(value = "/passport")
    public ModelAndView addPassport() {
        return new ModelAndView("documents/passport", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/passport", method = RequestMethod.POST)
    public String doAddPassport(@ModelAttribute("student") Student student, String commentary) {
        Document document = documentService.read(Document.PASSPORT_COPY);
        DocumentInfo passportInfo = student.getDocuments().get(document);
        passportInfo.setBrought(true);
        passportInfo.setCommentary(commentary);
        studentService.save(student);
        return "redirect:/abiturients";
    }

    /*
     *  Характеристика
     */
    @RequestMapping(value = "/characteristic")
    public ModelAndView addCharacteristic() {
        return new ModelAndView("documents/characteristic", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/characteristic", method = RequestMethod.POST)
    public String doAddCharacteristic(@ModelAttribute("student") Student student, String commentary) {
        Document document = documentService.read(Document.CHARACTERISTIC);
        DocumentInfo characteristicInfo = student.getDocuments().get(document);
        characteristicInfo.setBrought(true);
        characteristicInfo.setCommentary(commentary);
        studentService.save(student);
        return "redirect:/abiturients";
    }

    /*
     *  Направление на ВВК
     */
    @RequestMapping(value = "/direction")
    public ModelAndView addDirection() {
        return new ModelAndView("/documents/direction", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/direction", method = RequestMethod.POST)
    public String doAddDirection(@ModelAttribute("student") Student student, String office, String commentary) {
        Document document = documentService.read(Document.COMMISSION_DIRECTION);
        DocumentInfo directionInfo = student.getDocuments().get(document);
        directionInfo.setBrought(true);
        directionInfo.setCommentary(commentary);
        student.getQuestionnaire().setRecruitmentOffice(office);
        studentService.save(student);
        return "redirect:/abiturients";
    }

    /*
     *  Справка ВВК
     */
    @RequestMapping(value = "/certificate")
    public ModelAndView addCertificate() {
        return new ModelAndView("documents/certificate", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/certificate", method = RequestMethod.POST)
    public String doAddCertificate(@ModelAttribute("student") Student student, String commentary) {
        Document document = documentService.read(Document.COMMISSION_CERTIFICATE);
        DocumentInfo certificateInfo = student.getDocuments().get(document);
        certificateInfo.setBrought(true);
        certificateInfo.setCommentary(commentary);
        studentService.save(student);
        return "redirect:/abiturients";
    }

    /*
     *  Анкета
     */
    @RequestMapping(value = "/questionnaire")
    public ModelAndView addQuestionnaire() {
        return new ModelAndView("documents/questionnaire", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/questionnaire", method = RequestMethod.POST)
    public String doAddQuestionnaire(@Valid @ModelAttribute("student") Student student,
                                      BindingResult result, String commentary) {
        if (result.hasErrors()) {
            return "/documents/questionnaire";
        }
        Document document = documentService.read(Document.QUESTIONNAIRE);
        DocumentInfo questionnaireInfo = student.getDocuments().get(document);
        questionnaireInfo.setBrought(true);
        questionnaireInfo.setCommentary(commentary);
        studentService.save(student);
        return "redirect:/abiturients";
    }

    /*
    *  Средний Балл
    */
    @RequestMapping(value = "/score")
    public ModelAndView addScore() {
        return new ModelAndView("documents/score");
    }

    @RequestMapping(value = "/score", method = RequestMethod.POST)
    public String doAddScore(@Valid @ModelAttribute("student") Student student,
                              BindingResult result, String commentary) {
        if (result.hasErrors()) {
            return "/documents/score";
        }
        Document document = documentService.read(Document.AVERAGE_SCORE);
        DocumentInfo scoreInfo = student.getDocuments().get(document);
        scoreInfo.setBrought(true);
        scoreInfo.setCommentary(commentary);
        studentService.save(student);
        return "redirect:/abiturients";
    }

}
