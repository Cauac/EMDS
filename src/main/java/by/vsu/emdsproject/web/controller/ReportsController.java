package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.report.ReportGenerator;
import by.vsu.emdsproject.report.ReportGeneratorFactory;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.UserService;
import by.vsu.emdsproject.web.form.PersonCardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;

    @RequestMapping("")
    public ModelAndView reportsPage() {
        ModelAndView mav = new ModelAndView("/reports/list");
        mav.addObject("students", studentService.list());
        return mav;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView reportsPageDo(HttpServletResponse response, String id) {
        Student student = studentService.read(Long.parseLong(id));
        ReportGenerator generator = ReportGeneratorFactory.getDocxReportGenerator();
        generator.generatePersonCardReport(student, response);
        return null;
    }

    @RequestMapping("personCard")
    public ModelAndView personCard() {
        return new ModelAndView("/reports/personCard", "personCardForm", new PersonCardForm());
    }

}
