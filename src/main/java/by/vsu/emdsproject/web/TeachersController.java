package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.TeacherService;
import by.vsu.emdsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/teacher")
public class TeachersController {

    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teachers")
    public ModelAndView teachers() {
        ModelAndView mav = new ModelAndView("teacher/teachers/list");
        mav.addObject("teachers", teacherService.list());
        mav.addObject("users", userService.getTeachers());
        return mav;
    }

    @RequestMapping("/teachers/add")
    public String addTeacher() {
        return "teacher/teachers/add";
    }

    @RequestMapping(value = "/teachers/add", method = RequestMethod.POST)
    public String addTeacher(Teacher teacher, HttpServletRequest request) {
        teacherService.add(teacher);
        userService.addUserToPerson(User.TEACHER, teacher);
        request.getSession().setAttribute("password", "12345");
        return "redirect:/teacher/teachers";
    }

    @RequestMapping("/teachers/edit")
    public ModelAndView editTeacher(String id) {
        ModelAndView mav = new ModelAndView("teacher/teachers/edit");
        mav.addObject("teacher", teacherService.read(Long.parseLong(id)));
        return mav;
    }

    @RequestMapping(value = "/teachers/edit", method = RequestMethod.POST)
    public String editTeacher(String id, String rank) {
        Teacher teacher = teacherService.read(Long.parseLong(id));
        teacher.setRank(rank);
        teacherService.update(teacher);
        return "redirect:/teacher/teachers";
    }

    // TODO: check if this teacher is current user
    @RequestMapping("/teachers/remove")
    public String removeTeacher(String id) {
        User user = userService.getTeacherById(Long.parseLong(id));
        userService.remove(user);
        teacherService.remove(Long.parseLong(id));
        return "redirect:/teacher/teachers";
    }
}
