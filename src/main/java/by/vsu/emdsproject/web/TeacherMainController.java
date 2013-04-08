package by.vsu.emdsproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
public class TeacherMainController {

    @RequestMapping("")
    public String mainPage() {
        return "redirect:/teacher/students";
    }
}
