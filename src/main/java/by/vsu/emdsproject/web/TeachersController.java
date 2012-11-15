package by.vsu.emdsproject.web;

import by.vsu.emdsproject.common.PasswordUtils;
import by.vsu.emdsproject.common.Transliterator;
import by.vsu.emdsproject.model.Role;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.RoleService;
import by.vsu.emdsproject.service.TeacherService;
import by.vsu.emdsproject.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeachersController {

    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/teachers")
    public ModelAndView teachers() {
        ModelAndView mav = new ModelAndView("teacher/teachers/list");
        List<Teacher> teachers = teacherService.list();
        List<User> users = userService.getTeachers();
        mav.addObject("teachers", teachers);
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping("/teachers/add")
    public String addTeacher() {
        return "teacher/teachers/add";
    }

    @RequestMapping(value = "/teachers/add", method = RequestMethod.POST)
    public String addTeacher(Teacher teacher) {
        teacherService.add(teacher);

        Role role = roleService.getByName("ROLE_TEACHER");
        String username = Transliterator.transliterate(teacher.getLastName() + teacher.getFirstName().charAt(0) + teacher.getMiddleName().charAt(0));
        User user = new User(teacher.getId(), "teacher", username, PasswordUtils.encode("12345"), 1, role);

        userService.add(user);
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

    @RequestMapping("/teachers/remove")
    public String removeTeacher(String id) {
        User user = userService.getByPersonId(Long.parseLong(id));
        userService.remove(user);
        teacherService.remove(Long.parseLong(id));
        return "redirect:/teacher/teachers";
    }
}
