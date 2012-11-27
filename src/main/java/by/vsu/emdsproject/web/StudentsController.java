package by.vsu.emdsproject.web;

import by.vsu.emdsproject.common.PasswordUtils;
import by.vsu.emdsproject.common.Transliterator;
import by.vsu.emdsproject.exception.EMDSException;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.model.Role;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.QuestionnaireService;
import by.vsu.emdsproject.service.RoleService;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private GroupService groupService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private QuestionnaireService questionnaireService;

    @RequestMapping("/students")
    public ModelAndView students() {
        ModelAndView mav = new ModelAndView("teacher/students/list");
        mav.addObject("students", studentService.list());
        mav.addObject("users", userService.getStudents());
        return mav;
    }

    @RequestMapping("/students/add")
    public ModelAndView addStudent() {
        ModelAndView mav = new ModelAndView("teacher/students/add");
        mav.addObject("groups", groupService.list());
        return mav;
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.POST)
    public ModelAndView addStudent(Student s, String group, Questionnaire q,
            String dob, HttpServletRequest request) {
        Date d;
        ModelAndView mav;
        try {
            //questionnaireService.add(q);
            Group g = groupService.read(Long.parseLong(group));

            d = new SimpleDateFormat("dd.MM.yyyy").parse(dob);
            s.setQuestionnaire(q);
            q.setStudent(s);
            s.setBirthDate(d);
            s.setGroup(g);
            studentService.add(s);

            Role role = roleService.getByName("ROLE_STUDENT");
            String username = Transliterator.transliterate(s.getLastName()
                    + s.getFirstName().charAt(0) + s.getMiddleName().charAt(0));
            User user = new User(s.getId(), "student", username,
                    PasswordUtils.encode("12345"), 1, role);
            user.setDefaultPassword(true);
            userService.add(user);

            mav = new ModelAndView("redirect:/teacher/students");
            request.getSession().setAttribute("win", "Студент добавлен");
            return mav;
        } catch (Exception ex) {
            mav = new ModelAndView("redirect:/teacher/students/add");
            request.getSession().setAttribute("fail", "Ошибка при добавлении студента");
            return mav;
        }
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

    @RequestMapping(value = "/students/info")
    public ModelAndView fullInfoView(String id) {
        ModelAndView mav = new ModelAndView("teacher/students/fullInfo");
        mav.addObject("student", studentService.read(Long.parseLong(id)));
        return mav;
    }
}
