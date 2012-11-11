package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Speciality;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.SpecialityService;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String mainPage() {
        return "redirect:/teacher/students";
    }

    @RequestMapping("/teachers")
    public ModelAndView teachers() {
        ModelAndView mav = new ModelAndView("teacher/teachersList");
        List<User> teachers = userService.getTeachers();
        mav.addObject("teachers", teachers);
        return mav;
    }

    @RequestMapping("/students")
    public ModelAndView students() {
        ModelAndView mav = new ModelAndView("teacher/studentsList");
        List<User> students = userService.getStudents();
        mav.addObject("students", students);
        return mav;
    }

    @RequestMapping("/groups")
    public ModelAndView groups() {
        ModelAndView mav = new ModelAndView("teacher/groupsList");
        List<Group> groups = groupService.list();
        mav.addObject("groups", groups);
        return mav;
    }

    @RequestMapping("/specialities")
    public ModelAndView specialities() {
        ModelAndView mav = new ModelAndView("teacher/specialitiesList");
        List<Speciality> specialities = specialityService.list();
        mav.addObject("specialities", specialities);
        return mav;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addStudent(Student s) {
        studentService.add(s);
        return new ModelAndView("redirect:/student/studentList");
    }

    @RequestMapping(value = "/addSpeciality", method = RequestMethod.POST)
    public ModelAndView addSpeciality(Speciality s, Errors errors) {
        if (errors.hasErrors()) {
            ModelAndView mav = new ModelAndView("addSpeciality");
            mav.addObject("errors", errors);
            return mav;
        }
        specialityService.add(s);
        return new ModelAndView("redirect:/teacher/specialities");
    }

    @RequestMapping(value = "/addSpeciality")
    public String addSpeciality() {
        return "teacher/addSpeciality";
    }

    @RequestMapping("/addStudent")
    public String addStudent() {
        return "student/addStudent";
    }
}
