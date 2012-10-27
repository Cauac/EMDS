/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Speciality;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.SpecialityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Max
 */
@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;
    
    @Autowired
    private SpecialityService specialityService;

    @RequestMapping("/allGroups.htm")
    public ModelAndView allGroups() {
        List<Group> groups = groupService.listGroup();
        ModelAndView mav = new ModelAndView("group/groupList");
        mav.addObject("groups", groups);
        return mav;
    }

    @RequestMapping(value = "/addGroup.htm", method = RequestMethod.POST)
    public ModelAndView addGroup(Group p, Long speciality_id, Errors errors) {
        if (errors.hasErrors()) {
            ModelAndView mav = new ModelAndView("addGroup");
            mav.addObject("errors", errors);
            return mav;
        }
        Speciality sp = specialityService.readSpeciality(speciality_id);
        p.setSpeciality(sp);
        groupService.addGroup(p);
        return new ModelAndView("redirect:/allGroups.htm");
    }

    @RequestMapping(value = "/addGroup.htm")
    public String addGroup() {
        return "group/addGroup";
    }
}
