package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.exception.EMDSException;
import by.vsu.emdsproject.model.Document;
import by.vsu.emdsproject.model.DocumentInfo;
import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Part;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/file")
@Controller
public class FileUploadController {

    @Autowired
    FileAnalyzeService fileAnalyzeService;
    @Autowired
    StudentService studentService;
    @Autowired
    DocumentService documentService;
    @Autowired
    DocumentInfoService documentInfoService;
    @Autowired
    QuestionnaireService questionnaireService;

    @RequestMapping(value = "uploadProgressFile", method = RequestMethod.GET)
    public ModelAndView uploadProgressFile() {
        ModelAndView mav = new ModelAndView("/abiturients/uploadProgressFile");
        mav.addObject("faculties", Student.FACULTIES);
        return mav;
    }

    @RequestMapping(value = "uploadProgressFile", method = RequestMethod.POST)
    public ModelAndView uploadProgressFile(String faculty, @RequestParam(value = "file") Part file) {
        double p = 1;
        if (file != null) {
            byte[] fileContent = null;
            try {
                Map<String, String> progressMap = fileAnalyzeService.extractStudentProgress(file.getInputStream());
                List<Student> abiturients = studentService.getAbiturientsByFaculty(faculty);
                for (Student s : abiturients) {
                    String fio = ReportUtil.getFullFIO(s);
                    if (progressMap.containsKey(fio)) {
                        Document document = documentService.read(Document.AVERAGE_SCORE);
                        DocumentInfo documentInfo = s.getDocuments().get(document);
                        documentInfo.setBrought(true);
                        documentInfo.setCommentary(progressMap.get(fio));
                        documentInfoService.save(documentInfo);
                    }
                }
            } catch (Exception ex) {
                throw new EMDSException("Ошибка при загрузке файла");
            }
        }
        return new ModelAndView("redirect:/abiturients");
    }

    @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] downloadPhoto(@PathVariable("id") Long id) {

        Questionnaire q = questionnaireService.read(id);
        return q.getPhoto();
    }
}