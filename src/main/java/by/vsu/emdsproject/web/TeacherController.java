package by.vsu.emdsproject.web;

import by.vsu.emdsproject.common.EMDSContext;
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
public class TeacherController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String mainPage () {
        return "redirect:/teacher/students";
    }
    
    @RequestMapping("/teachers")
    public ModelAndView teachers() {
        ModelAndView mav = new ModelAndView("teacher/teachersList");
        List<User> teachers = userService.getTeachers();
        mav.addObject("teachers", teachers);
        return mav;
    }
    
    @RequestMapping("/students")
    public ModelAndView students() {
        ModelAndView mav = new ModelAndView("teacher/studentsList");
        List<User> students = userService.getStudents();
        mav.addObject("students", students);
        return mav;
    }

    
    
    
    
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addStudent(Student s) {
        studentService.add(s);
        return new ModelAndView("redirect:/student/studentList");
    }

    @RequestMapping("/addStudent")
    public String addStudent() {
        return "student/addStudent";
    }
}
