package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.UserService;
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
        mav.addObject("students", studentService.list());
        mav.addObject("users", userService.getStudents());
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
    
    
    @RequestMapping("/students/edit")
    public ModelAndView editStudent(String id) {
        ModelAndView mav = new ModelAndView("teacher/students/edit");
        mav.addObject("student", studentService.read(Long.parseLong(id)));
        return mav;
    }
    

    @RequestMapping(value = "/students/remove")
    public String removeStudent(String id) {
        User user = userService.getByStudentId(Long.parseLong(id));
        userService.remove(user);
        studentService.remove(Long.parseLong(id));
        return "redirect:/teacher/students";
    }
}
