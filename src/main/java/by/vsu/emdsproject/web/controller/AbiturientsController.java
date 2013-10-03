package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Group;
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
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

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

    @ModelAttribute("student")
    public Student setAbiturient(Long id) {
        if (id != null) {
            return studentService.read(id);
        } else {
            return new Student();
        }
    }

    @RequestMapping("")
    public ModelAndView abiturients(@ModelAttribute("list") Integer list, ModelMap modelMap) {
        modelMap.addAttribute("list", 1);
        ModelAndView mav = new ModelAndView("/abiturients/list");
        List<Student> abiturients = studentService.getAbiturients();
        Collections.sort(abiturients, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getQuestionnaire().getFaculty().compareTo(o2.getQuestionnaire().getFaculty());
            }
        });
        Map<Student, Boolean> readiness = new HashMap<>();
        for (Student abiturient : abiturients) {
            readiness.put(abiturient, studentService.readyToTake(abiturient));
        }        
        List<String> faculties = new ArrayList<>();
        faculties.add("Все факультеты");
        faculties.addAll(Arrays.asList(Student.FACULTIES));
        mav.addObject("abiturients", abiturients);
        mav.addObject("documents", documentService.list());
        mav.addObject("readiness", readiness);
        mav.addObject("faculties", faculties);
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView addAbiturients() {
        ModelAndView mav = new ModelAndView("/abiturients/add");
        mav.addObject("faculties", Arrays.asList(Student.FACULTIES));
        return mav;
    }

    @RequestMapping(value = "/doAdd", method = RequestMethod.POST)
    public ModelAndView addAbiturient(@Valid Student student, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("/abiturients/add", "faculties", Arrays.asList(Student.FACULTIES));
        }
        student.setType(Student.ABITURIENT);
        studentService.save(student);
        request.getSession().setAttribute("win", student.getLastName() + " "
                + student.getFirstName() + " добавлен в список поступающих");

        return new ModelAndView("redirect:/abiturients");
    }

    @RequestMapping(value = "/remove")
    public String removeAbiturient(@ModelAttribute("student") Student student, HttpServletRequest request) {
        studentService.fail(student);
        request.getSession().setAttribute("win", "Информация о студенте перенесена в архив");
        return "redirect:/abiturients";
    }

    @RequestMapping(value = "/studentialize")
    public ModelAndView toStudent() {
        return new ModelAndView("/abiturients/studentialize", "groups", groupService.list());
    }

    @RequestMapping(value = "/studentialize", method = RequestMethod.POST)
    public String doToStudent(@ModelAttribute("student") Student student, Long groupId, HttpServletRequest request) {
        studentService.toJunior(student);
        Group group = groupService.read(groupId);
        group.getStudents().add(student);
        student.setGroup(group);
        student.getQuestionnaire().setEducationStartDate(new Date());
        studentService.save(student);
        groupService.save(group);
        request.getSession().setAttribute("win", student.getLastName() + " "
                + student.getFirstName() + " переведен в студенты");
        return "redirect:/students/junior";
    }

}
