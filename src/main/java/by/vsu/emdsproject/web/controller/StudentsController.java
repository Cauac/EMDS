package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.common.EMDSGlobal;
import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

// todo: students @ModelAttribute add
@Controller
@RequestMapping("/students")
@SessionAttributes({"list"})
public class StudentsController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;

    @ModelAttribute("list")
    public Integer getList() {
        return 1;
    }

    @RequestMapping("")
    public String students(@ModelAttribute("list") Integer list) {
        switch (list) {
            case 1:
                return "redirect:/students/junior";
            case 2:
                return "redirect:/students/officer";
            case 3:
                return "redirect:/abiturients";
            case 4:
                return "redirect:/students/archive";
            default:
                return "redirect:/students/junior";
        }
    }

    @RequestMapping("/junior")
    public ModelAndView juniors(@ModelAttribute("list") Integer list, ModelMap modelMap) {
        modelMap.addAttribute("list", 1);
        ModelAndView mav = new ModelAndView("/students/juniorList");
        mav.addObject("students", studentService.getJuniors());
        return mav;
    }

    @RequestMapping("/officer")
    public ModelAndView officers(@ModelAttribute("list") Integer list, ModelMap modelMap) {
        modelMap.addAttribute("list", 2);
        ModelAndView mav = new ModelAndView("/students/officerList");
        mav.addObject("students", studentService.getOfficers());
        return mav;
    }

    @RequestMapping("/archive")
    public ModelAndView archive(@ModelAttribute("list") Integer list, ModelMap modelMap) {
        modelMap.addAttribute("list", 4);
        ModelAndView mav = new ModelAndView("/students/archiveList");
        List<Student> students = new ArrayList<Student>();
        students.addAll(studentService.getFailed());
        students.addAll(studentService.getReserve());
        mav.addObject("students", students);
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView addStudent() {
        ModelAndView mav = new ModelAndView("/students/add");
        mav.addObject("groups", groupService.list());
        return mav;
    }

    @RequestMapping("/purge")
    public String purgeStudent(Student abiturient) {
        studentService.remove(abiturient.getId());
        return "redirect:/students/archive";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addStudent(Student student, String group, Questionnaire questionnaire,
                                   String dateOfBirth, HttpServletRequest request) {
        ModelAndView modelAndView;
        try {
            student.setBirthDate(EMDSGlobal.dateFormat.parse(dateOfBirth));
            student.setGroup(groupService.read(Long.parseLong(group)));
            student.setQuestionnaire(questionnaire);
            student.setType(Student.JUNIOR);
            studentService.add(student);
            modelAndView = new ModelAndView("redirect:/students");
            request.getSession().setAttribute("win", "Студент добавлен");
        } catch (Exception ex) {
            modelAndView = new ModelAndView("redirect:/students/add");
            request.getSession().setAttribute("fail", "Ошибка при добавлении студента");
        }
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView editStudent(String id) {
        ModelAndView mav = new ModelAndView("students/edit");
        mav.addObject("student", studentService.read(Long.parseLong(id)));
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String doEditStudent(Student student) {
        // todo
        return "redirect:/students";
    }

    @RequestMapping(value = "/remove")
    public String removeStudent(Long id) {
        studentService.toArchive(studentService.read(id));
        return "redirect:/students";
    }

    @RequestMapping(value = "/info")
    public ModelAndView fullInfoView(String id) {
        ModelAndView mav = new ModelAndView("/students/fullInfo");
        mav.addObject("student", studentService.read(Long.parseLong(id)));
        return mav;
    }
}
