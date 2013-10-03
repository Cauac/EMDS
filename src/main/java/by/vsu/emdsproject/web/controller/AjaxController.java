package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.DocumentService;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.StudentService;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Max
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private DocumentService documentService;

    @RequestMapping("allGroups")
    public @ResponseBody
    List<Group> groupList() {
        return groupService.list();
    }

    @RequestMapping("studentsByGroup")
    public @ResponseBody
    List<Student> studentsList(Long groupId) {
        return studentService.findByGroup(groupService.read(groupId));
    }

    @RequestMapping("archiveList")
    public @ResponseBody
    ModelAndView archiveList(Integer reserve, Integer dismissed, Integer cancelled) {
        List<Student> students = new ArrayList<>();
        if (dismissed != 0) {
            students.addAll(studentService.getDismissed());
        }
        if (reserve != 0) {
            students.addAll(studentService.getReserve());
        }
        if (cancelled != 0) {
            students.addAll(studentService.getFailed());
        }
        return new ModelAndView("students/archiveListAjax", "students", students);
    }

    @RequestMapping("abiturientsList")
    public @ResponseBody
    ModelAndView abiturientList(String faculty) {
        ModelAndView mav = new ModelAndView("abiturients/abiturientsListAjax");
        List<Student> students;
        if (!faculty.equals("Все факультеты")) {
            students = studentService.getAbiturientsByFaculty(faculty);
        } else {
            students = studentService.getAbiturients();
        }
        Map<Student, Boolean> readiness = new HashMap<>();
        for (Student abiturient : students) {
            readiness.put(abiturient, studentService.readyToTake(abiturient));
        }
        mav.addObject("documents", documentService.list());
        mav.addObject("readiness", readiness);
        mav.addObject("abiturients", students);
        return mav;
    }

}
