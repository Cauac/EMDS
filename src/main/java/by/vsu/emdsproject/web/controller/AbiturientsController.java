package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.DocumentService;
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

import java.util.*;

// todo: @ControllerAdvice for all controllers?
@Controller
@RequestMapping("/abiturients")
@SessionAttributes("list")
public class AbiturientsController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private DocumentService documentService;

    @ModelAttribute("abiturient")
    public Student setAbiturient(Long id) {
        if (id != null) {
            return studentService.read(id);
        } else {
            return new Student();
        }
    }

    @RequestMapping("")
    public ModelAndView abiturients(@ModelAttribute("list") Integer list, ModelMap modelMap) {
        modelMap.addAttribute("list", 3);
        ModelAndView mav = new ModelAndView("/abiturients/list");
        List<Student> abiturients = studentService.getAbiturients();
        Collections.sort(abiturients, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getQuestionnaire().getFaculty().compareTo(o2.getQuestionnaire().getFaculty());
            }
        });
        Map<Student, Boolean> readiness = new HashMap<Student, Boolean>();
        for (Student abiturient : abiturients) {
            readiness.put(abiturient, studentService.readyToTake(abiturient));
        }
        mav.addObject("abiturients", abiturients);
        mav.addObject("documents", documentService.list());
        mav.addObject("readiness", readiness);
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView addAbiturients() {
        ModelAndView mav = new ModelAndView("/abiturients/add");
        List<String> faculties = new ArrayList<String>();
        faculties.add("Математический");
        faculties.add("Физический");
        faculties.add("Биологический");
        faculties.add("Физической культуры и спорта");
        faculties.add("Исторический");
        faculties.add("Социальной педагогики и психологии");
        faculties.add("Филологический");
        faculties.add("Белорусской филологии и культры");
        faculties.add("Юридический");
        faculties.add("Художественно-графический");
        faculties.add("Педагогический");
        mav.addObject("faculties", faculties);
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAbiturient(String fname, String lname, String mname, String faculty) {
        Student student = new Student();
        student.setFirstName(fname);
        student.setLastName(lname);
        student.setMiddleName(mname);
        student.setType(Student.ABITURIENT);
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setFaculty(faculty);
        student.setQuestionnaire(questionnaire);
        studentService.add(student);
        return "redirect:/abiturients";
    }

    @RequestMapping(value = "/remove")
    public String removeAbiturient(@ModelAttribute("abiturient") Student abiturient) {
        studentService.toArchive(abiturient);
        return "redirect:/abiturients";
    }

    @RequestMapping(value = "/studentialize")
    public ModelAndView toStudent() {
        return new ModelAndView("/abiturients/studentialize", "groups", groupService.list());
    }

    @RequestMapping(value = "/studentialize", method = RequestMethod.POST)
    public String doToStudent(@ModelAttribute("abiturient") Student abiturient, Long groupId) {
        studentService.toJunior(abiturient);
        Group group = groupService.read(groupId);
        group.getStudents().add(abiturient);
        abiturient.setGroup(group);
        studentService.update(abiturient);
        groupService.update(group);
        return "redirect:/students/junior";
    }

}
