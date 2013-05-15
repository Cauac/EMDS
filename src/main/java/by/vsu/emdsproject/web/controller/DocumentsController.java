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

    @ModelAttribute("abiturient")
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
    private ModelAndView addStatement() {
        return new ModelAndView("/documents/statement", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/statement", method = RequestMethod.POST)
    private String doAddStatement(@ModelAttribute("abiturient") Student abiturient, String commentary) {
        Document document = documentService.read(Document.STATEMENT);
        DocumentInfo statementInfo = abiturient.getDocuments().get(document);
        statementInfo.setBrought(true);
        statementInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/abiturients";
    }

    /*
     *  Копия приписного свидетельства
     */
    @RequestMapping(value = "/registration")
    private ModelAndView addRegistration() {
        return new ModelAndView("documents/registration", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    private String doAddRegistration(@ModelAttribute("abiturient") Student abiturient, String commentary) {
        Document document = documentService.read(Document.REGISTRATION_CERTIFICATE_COPY);
        DocumentInfo registrationInfo = abiturient.getDocuments().get(document);
        registrationInfo.setBrought(true);
        registrationInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/abiturients";
    }

    /*
     *  Копия паспорта
     */
    @RequestMapping(value = "/passport")
    private ModelAndView addPassport() {
        return new ModelAndView("documents/passport", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/passport", method = RequestMethod.POST)
    private String doAddPassport(@ModelAttribute("abiturient") Student abiturient, String commentary) {
        Document document = documentService.read(Document.PASSPORT_COPY);
        DocumentInfo passportInfo = abiturient.getDocuments().get(document);
        passportInfo.setBrought(true);
        passportInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/abiturients";
    }

    /*
     *  Характеристика
     */
    @RequestMapping(value = "/characteristic")
    private ModelAndView addCharacteristic() {
        return new ModelAndView("documents/characteristic", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/characteristic", method = RequestMethod.POST)
    private String doAddCharacteristic(@ModelAttribute("abiturient") Student abiturient, String commentary) {
        Document document = documentService.read(Document.CHARACTERISTIC);
        DocumentInfo characteristicInfo = abiturient.getDocuments().get(document);
        characteristicInfo.setBrought(true);
        characteristicInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/abiturients";
    }

    /*
     *  Направление на ВВК
     */
    @RequestMapping(value = "/direction")
    private ModelAndView addDirection() {
        return new ModelAndView("/documents/direction", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/direction", method = RequestMethod.POST)
    private String doAddDirection(@ModelAttribute("abiturient") Student abiturient, String office, String commentary) {
        Document document = documentService.read(Document.COMMISSION_DIRECTION);
        DocumentInfo directionInfo = abiturient.getDocuments().get(document);
        directionInfo.setBrought(true);
        directionInfo.setCommentary(commentary);
        abiturient.getQuestionnaire().setRecruitmentOffice(office);
        studentService.update(abiturient);
        return "redirect:/abiturients";
    }

    /*
     *  Справка ВВК
     */
    @RequestMapping(value = "/certificate")
    private ModelAndView addCertificate() {
        return new ModelAndView("documents/certificate", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/certificate", method = RequestMethod.POST)
    private String doAddCertificate(@ModelAttribute("abiturient") Student abiturient, String commentary) {
        Document document = documentService.read(Document.COMMISSION_CERTIFICATE);
        DocumentInfo certificateInfo = abiturient.getDocuments().get(document);
        certificateInfo.setBrought(true);
        certificateInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/abiturients";
    }

    /*
     *  Анкета
     */
    @RequestMapping(value = "/questionnaire")
    private ModelAndView addQuestionnaire() {
        return new ModelAndView("documents/questionnaire", "currentDate", EMDSGlobal.dateFormat.format(new Date()));
    }

    @RequestMapping(value = "/questionnaire", method = RequestMethod.POST)
    private String doAddQuestionnaire(@Valid @ModelAttribute("abiturient") Student abiturient,
                                      BindingResult result, String commentary) {
        if (result.hasErrors()) {
            return "/documents/questionnaire";
        }
        Document document = documentService.read(Document.QUESTIONNAIRE);
        DocumentInfo questionnaireInfo = abiturient.getDocuments().get(document);
        questionnaireInfo.setBrought(true);
        questionnaireInfo.setCommentary(commentary);
        studentService.update(abiturient);
        return "redirect:/abiturients";
    }

}
