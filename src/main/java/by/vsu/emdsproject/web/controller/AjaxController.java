package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("allGroups")
    public
    @ResponseBody
    List<Group> groupList() {
        return groupService.list();
    }

    @RequestMapping("studentsByGroup")
    public
    @ResponseBody
    List<Student> studentsList(Long groupId) {
        return studentService.findByGroup(groupService.read(groupId));
    }

}
