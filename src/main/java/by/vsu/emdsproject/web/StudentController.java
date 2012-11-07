package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/allStudents")
    public ModelAndView allStudents() {
        List<Student> students = studentService.listStudent();
        ModelAndView mav = new ModelAndView("student/studentList");
        mav.addObject("students", students);
        return mav;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addStudent(Student s) {
        studentService.addStudent(s);
        return new ModelAndView("redirect:/student/studentList");
    }

    @RequestMapping("/addStudent")
    public String addStudent() {
        return "student/addStudent";
    }
}
