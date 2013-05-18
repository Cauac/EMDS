package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.report.ReportGenerator;
import by.vsu.emdsproject.report.ReportGeneratorFactory;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.TeacherService;
import by.vsu.emdsproject.web.form.AbstractReportForm;
import by.vsu.emdsproject.web.form.AllowedListForm;
import by.vsu.emdsproject.web.form.ExamProtocolForm;
import by.vsu.emdsproject.web.form.PersonCardForm;
import by.vsu.emdsproject.web.propertyeditor.GroupEditor;
import by.vsu.emdsproject.web.propertyeditor.StudentEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;

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

    @InitBinder("personCardForm")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Student.class, "student", new StudentEditor(studentService));
        binder.registerCustomEditor(Group.class, "group", new GroupEditor(groupService));
    }

    @RequestMapping("")
    public ModelAndView reportsPage() {
        return new ModelAndView("/reports/list");
    }


    @RequestMapping("personCard")
    public ModelAndView personCard() {
        ModelAndView modelAndView = new ModelAndView("/reports/personCard");
        modelAndView.addObject("form", new PersonCardForm());
        return modelAndView;
    }

    @RequestMapping("examStatement")
    public ModelAndView examStatement() {
        ModelAndView mav = new ModelAndView("/reports/examStatement");
        mav.addObject("groups", groupService.list());
        mav.addObject("teachers", teacherService.list());
//        mav.addObject("formType", ExamStatementForm.class);
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
        mav.addObject("formType", ExamProtocolForm.class);
        return mav;
    }

    @RequestMapping("allowedList")
    public ModelAndView allowedList() {
        ModelAndView mav = new ModelAndView("/reports/allowedList");
        mav.addObject("form", new AllowedListForm());
        mav.addObject("groups", groupService.list());
        return mav;
    }


    @RequestMapping(value = "generateReport", method = RequestMethod.POST)
    public ModelAndView generateReportDo(AbstractReportForm form, HttpServletResponse response) {
        ReportGenerator generator = ReportGeneratorFactory.getDocxReportGenerator();
        AbstractReportDataSource dataSource = form.getReportDataSource();
        Map parameters = form.getReportDataMap();
        dataSource.init(parameters);
        generator.generate(dataSource, response);
        return null;
    }
//
//    @RequestMapping(value = "examStatement", method = RequestMethod.POST)
//    public ModelAndView reportExamStatementDo(HttpServletResponse response, HttpServletRequest request, @ModelAttribute("group") Group group, @RequestParam("teacher") Long[] param) {
//        ReportGenerator generator = ReportGeneratorFactory.getDocxReportGenerator();
//        List<Teacher> teachers = new ArrayList<Teacher>();
//        for (Long id : param) {
//            teachers.add(teacherService.read(id));
//        }
//        generator.generateExamStatementReport(group, teacherService.getChief(), teachers, response);
//        return null;
//    }
//
//    @RequestMapping(value = "examProtocol", method = RequestMethod.POST)
//    public ModelAndView reportExamProtocolDo(HttpServletResponse response, @ModelAttribute("group") Group group, @RequestParam("member") String[] param) {
//        ReportGenerator generator = ReportGeneratorFactory.getDocxReportGenerator();
//        generator.generateExamProtocolReport(group, param, response);
//        return null;
//    }
//
//    @RequestMapping(value = "allowedList", method = RequestMethod.POST)
//    public ModelAndView reportAllowedListDo(HttpServletResponse response, @ModelAttribute("group") Group group) {
//        ReportGenerator generator = ReportGeneratorFactory.getDocxReportGenerator();
//        generator.generateAllowedListReport(group, teacherService.getChief(), response);
//        return null;
//    }

}
