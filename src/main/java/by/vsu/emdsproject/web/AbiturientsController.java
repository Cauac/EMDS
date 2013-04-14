package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.DocumentInfoService;
import by.vsu.emdsproject.service.DocumentService;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/teacher/abiturients")
public class AbiturientsController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private DocumentInfoService documentInfoService;

    @RequestMapping("")
    public ModelAndView abiturients() {
        ModelAndView mav = new ModelAndView("/teacher/abiturients/list");
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
        ModelAndView mav = new ModelAndView("teacher/abiturients/add");
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
    public ModelAndView addAbiturient(String fname, String lname, String mname, String faculty) {
        Student student = new Student();
        student.setFirstName(fname);
        student.setLastName(lname);
        student.setMiddleName(mname);
        student.setRank(Student.ABITURIENT);
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setFaculty(faculty);
        student.setQuestionnaire(questionnaire);
        studentService.add(student);
        return new ModelAndView("redirect:/teacher/abiturients");
    }

    @RequestMapping(value = "/remove")
    public String removeAbiturient(String id) {
        Student abiturient = studentService.read(Long.parseLong(id));
        abiturient.getDocuments().clear();
        studentService.remove(abiturient);
        return "redirect:/teacher/abiturients";
    }

    @RequestMapping(value = "/studentialize")
    public String toStudent(Long id) {
        Student student = studentService.read(id);
        student.setRank(Student.STUDENT);
        userService.addUserToPerson(User.STUDENT, student);
        studentService.update(student);
        return "redirect:/teacher/abiturients";
    }

}
