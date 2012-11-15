package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.SpecialtyService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class GroupsController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private SpecialtyService specService;

    @RequestMapping("/groups")
    public ModelAndView groups() {
        ModelAndView mav = new ModelAndView("teacher/groups/list");
        List<Group> groups = groupService.list();
        mav.addObject("groups", groups);
        return mav;
    }

    @RequestMapping("/groups/add")
    public ModelAndView addGroup() {
        ModelAndView mav = new ModelAndView("teacher/groups/add");
        List<Specialty> list = specService.list();
        mav.addObject("specialties", list);
        return mav;
    }

    @RequestMapping(value = "/groups/add", method = RequestMethod.POST)
    public ModelAndView addGroup(Group group, Long specId) {
        Specialty spec = specService.read(specId);
        Set<Group> groups = spec.getGroups();
        group.setSpecialty(spec);
        groupService.add(group);
        return new ModelAndView("redirect:/teacher/groups");
    }

    @RequestMapping("/groups/edit")
    public ModelAndView editGroup(String id) {
        ModelAndView mav = new ModelAndView("teacher/groups/edit");
        List<Specialty> list = specService.list();
        mav.addObject("specialties", list);
        mav.addObject("group", groupService.read(Long.parseLong(id)));
        return mav;
    }

    @RequestMapping(value = "/groups/edit", method = RequestMethod.POST)
    public ModelAndView editGroup(Group group, Long specId) {
        group.setSpecialty(specService.read(specId));
        groupService.update(group);
        return new ModelAndView("redirect:/teacher/groups");
    }

    @RequestMapping(value = "/groups/remove")
    public String removeGroup(String id) {
        groupService.remove(Long.parseLong(id));
        return "redirect:/teacher/groups";
    }
}
