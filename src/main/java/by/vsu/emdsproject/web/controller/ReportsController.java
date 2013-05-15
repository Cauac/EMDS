package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.report.ReportGenerator;
import by.vsu.emdsproject.report.ReportGeneratorFactory;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.TeacherService;
import by.vsu.emdsproject.service.UserService;
import by.vsu.emdsproject.web.form.PersonCardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;

    /*@InitBinder("student")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Student.class, "student", new StudentEditor(studentService));
    }*/

    @ModelAttribute("student")
    public Student getStudent(Long student) {
        if (student != null) {
            Student s = studentService.read(student);
            return s;
        } else {
            return new Student();
        }
    }

    @ModelAttribute("group")
    public Group getGroup(Long group) {
        if (group != null) {
            Group g = groupService.read(group);
            return g;
        } else {
            return new Group();
        }
    }


//    @ModelAttribute("form")
//    public PersonCardForm getForm () {
//        return new PersonCardForm();
//    }

    @RequestMapping("")
    public ModelAndView reportsPage() {
        return new ModelAndView("/reports/list");
    }

    @RequestMapping(value = "personCard", method = RequestMethod.POST)
    public ModelAndView reportPersonCardDo(HttpServletResponse response, @ModelAttribute("student") Student student) {
        ReportGenerator generator = ReportGeneratorFactory.getDocxReportGenerator();
        generator.generatePersonCardReport(student, response);
        return null;
    }

    @RequestMapping(value = "examStatement", method = RequestMethod.POST)
    public ModelAndView reportExamStatementDo(HttpServletResponse response, @ModelAttribute("group") Group group) {
        ReportGenerator generator = ReportGeneratorFactory.getDocxReportGenerator();
        generator.generateExamStatementReport(group, teacherService.getChief(), response);
        return null;
    }

    @RequestMapping(value = "examProtocol", method = RequestMethod.POST)
    public ModelAndView reportExamProtocolDo(HttpServletResponse response, @ModelAttribute("group") Group group, @RequestParam("member") String[] param) {
        ReportGenerator generator = ReportGeneratorFactory.getDocxReportGenerator();
        generator.generateExamProtocolReport(group, param, response);
        return null;
    }

    @RequestMapping("personCard")
    public ModelAndView personCard() {
        return new ModelAndView("/reports/personCard", "personCardForm", new PersonCardForm());
    }

    @RequestMapping("examStatement")
    public ModelAndView examStatement() {
        ModelAndView mav = new ModelAndView("/reports/examStatement");
        mav.addObject("groups", groupService.list());
        return mav;
    }

    @RequestMapping("examProtocol")
    public ModelAndView examProtocol() {
        ModelAndView mav = new ModelAndView("/reports/examProtocol");
        mav.addObject("groups", groupService.list());
        List<Teacher> teachers = teacherService.list();
        List<String> result = new ArrayList<String>();
        for (Teacher t : teachers) {
            String fio = t.getLastName() + " " + t.getFirstName().charAt(0) + "." + t.getMiddleName().charAt(0) + ".";
            result.add(t.getRank() + " " + fio);
        }
        mav.addObject("teachers", result);
        return mav;
    }

}
