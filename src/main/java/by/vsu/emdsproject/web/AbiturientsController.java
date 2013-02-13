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
@RequestMapping("/teacher")
public class AbiturientsController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/abiturients")
    public ModelAndView abiturients() {
        ModelAndView mav = new ModelAndView("teacher/abiturients/list");
        List<Student> abiturients = studentService.getAbiturients();
        mav.addObject("abiturients", abiturients);
        return mav;
    }

    @RequestMapping("/abiturients/add")
    public String addAbiturients() {
        return "teacher/abiturients/add";
    }

    @RequestMapping(value = "/abiturients/add", method = RequestMethod.POST)
    public ModelAndView addAbiturient(String fname, String lname, String mname) {
        Student student = new Student();
        student.setFirstName(fname);
        student.setLastName(lname);
        student.setMiddleName(mname);
        student.toAbiturient();
        studentService.add(student);
        return new ModelAndView("redirect:/teacher/abiturients");
    }
    
    @RequestMapping(value="/abiturients/studentialize")
    public String toStudent (Long id) {
        Student s = studentService.read(id);
        s.toStudent();
        studentService.update(s);
        return "redirect:/teacher/abiturients";
    }
    
}
