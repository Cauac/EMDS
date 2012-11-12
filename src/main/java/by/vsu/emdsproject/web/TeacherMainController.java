package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("teacher")
public class TeacherMainController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String mainPage() {
        return "redirect:/teacher/students";
    }

    @RequestMapping("/teachers")
    public ModelAndView teachers() {
        ModelAndView mav = new ModelAndView("teacher/teachers/list");
        List<User> teachers = userService.getTeachers();
        mav.addObject("teachers", teachers);
        return mav;
    }

    @RequestMapping("/teachers/add")
    public String addTeacher() {
        return "teacher/teachers/add";
    }
    
    @RequestMapping(value = "/teachers/add", method = RequestMethod.POST)
    public ModelAndView addTeacher(Teacher teacher) {
//        teacherService.add(teacher);
        return new ModelAndView("redirect:/teacher/teachers");
    }
    


    

    

    
}
