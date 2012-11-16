package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class ReportsController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private StudentService studentService;

    @RequestMapping("/reports")
    public ModelAndView reportsPage() {
        ModelAndView mav = new ModelAndView("teacher/reports/list");
        mav.addObject("students", studentService.list());
        return mav;
    }

    @RequestMapping(value = "/reports", method = RequestMethod.POST)
    public String reportsPageDo(String id) {
        Student student = studentService.read(Long.parseLong(id));
        
        // .........
        // ????????
        // PROFIT
        
        return "index";
    }
}
