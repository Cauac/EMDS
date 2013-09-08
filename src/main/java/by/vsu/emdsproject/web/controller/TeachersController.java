package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.model.comparator.TeacherComporator;
import by.vsu.emdsproject.service.TeacherService;
import by.vsu.emdsproject.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;

    @ModelAttribute("teacher")
    public Teacher getTeacher(Long id) {
        if (id != null) {
            return teacherService.read(id);
        } else {
            return new Teacher();
        }
    }

    @RequestMapping("")
    public ModelAndView teachers() {
        ModelAndView mav = new ModelAndView("/teachers/list");
        List<Teacher> teachers = teacherService.list();
        Collections.sort(teachers, new TeacherComporator());
        mav.addObject("teachers", teachers);
        mav.addObject("users", userService.getTeachers());
        return mav;
    }

    @RequestMapping("/add")
    public String addTeacher() {
        return "/teachers/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTeacher(Teacher teacher, HttpServletRequest request) {
        teacherService.add(teacher);
        userService.addUserToPerson(User.TEACHER, teacher);
        request.getSession().setAttribute("password", "12345");
        return "redirect:/teachers";
    }

    @RequestMapping("/edit")
    public ModelAndView editTeacher(String id) {
        ModelAndView mav = new ModelAndView("/teachers/edit");
        mav.addObject("teacher", teacherService.read(Long.parseLong(id)));
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editTeacher(@ModelAttribute("teacher") @Valid Teacher teacher, BindingResult result) {
//        Teacher teacher = teacherService.read(Long.parseLong(id));
//        teacher.setRank(rank);
        teacherService.update(teacher);
        return "redirect:/teachers";
    }

    @RequestMapping("/remove")
    public ModelAndView removeTeacher(String id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/teachers");
        User user = userService.getUserByTeacherId(Long.parseLong(id));
        if (!StringUtils.equals(EMDSContext.getInstance().getCurrentUser().getUsername(), user.getLogin())) {
            userService.remove(user.getId());
            teacherService.remove(Long.parseLong(id));
        }
        return modelAndView;
    }

    @RequestMapping("/chief")
    public ModelAndView setChief() {
        return new ModelAndView("/teachers/chief", "teachers", teacherService.list());
    }

    @RequestMapping(value = "/chief", method = RequestMethod.POST)
    public String doSetChief(Long id) {
        List<Teacher> teachers = teacherService.list();
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                teacher.setChief(true);
            } else {
                teacher.setChief(false);
            }
            teacherService.update(teacher);
        }
        return "redirect:/teachers";
    }

}
