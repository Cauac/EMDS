package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("teacher")
public class StudentsController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;

    @RequestMapping("/students")
    public ModelAndView students() {
        ModelAndView mav = new ModelAndView("teacher/students/list");
        List<User> students = userService.getStudents();
        mav.addObject("students", students);
        return mav;
    }

    @RequestMapping("/students/add")
    public String addStudent() {
        return "teacher/students/add";
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.POST)
    public ModelAndView addStudent(Student s) {
        studentService.add(s);
        return new ModelAndView("redirect:/teacher/students");
    }

    @RequestMapping(value = "/students/remove")
    public String removeGroup(String id) {
        studentService.remove(Long.parseLong(id));
        return "redirect:teacher/students";
    }
}
