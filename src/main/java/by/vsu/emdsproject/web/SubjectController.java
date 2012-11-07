package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Subject;
import by.vsu.emdsproject.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("teacher/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/allSubjects")
    public ModelAndView allSubject() {
        List<Subject> subjects = subjectService.listSubject();
        ModelAndView mav = new ModelAndView("subject/subjectList");
        mav.addObject("subjects", subjects);
        return mav;
    }

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public ModelAndView addSubject(Subject s) {
        subjectService.addSubject(s);
        return new ModelAndView("redirect:/subject/subjectList");
    }

    @RequestMapping("/addSubject")
    public String addSubject() {
        return "subject/addSubject";
    }
}
