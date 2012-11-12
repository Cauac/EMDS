package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.service.GroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherGroupsController {

    @Autowired
    private GroupService groupService;
    
    @RequestMapping("/groups")
    public ModelAndView groups() {
        ModelAndView mav = new ModelAndView("teacher/groups/list");
        List<Group> groups = groupService.list();
        mav.addObject("groups", groups);
        return mav;
    }
    
    @RequestMapping("/groups/add")
    public String addGroup() {
        return "teacher/groups/add";
    }
    
    @RequestMapping(value = "/groups/add", method = RequestMethod.POST)
    public ModelAndView addGroup(Group group, Errors errors) {
        if (errors.hasErrors()) {
            ModelAndView mav = new ModelAndView("teacher/groups/add");
            mav.addObject("errors", errors);
            return mav;
        }
        groupService.add(group);
        return new ModelAndView("redirect:/teacher/groups");
    }
    
    @RequestMapping(value = "/groups/remove")
    public String removeGroup(String id) {
        groupService.remove(Long.parseLong(id));
        return "redirect:teacher/groups";
    }
    
}
