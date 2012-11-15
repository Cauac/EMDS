package by.vsu.emdsproject.web;

import by.vsu.emdsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
public class TeacherMainController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String mainPage() {
        return "redirect:/teacher/students";
    }
}
