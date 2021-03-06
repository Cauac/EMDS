package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.SpecialtyService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private SpecialtyService specialtyService;

    @RequestMapping("")
    public ModelAndView groups() {
        return new ModelAndView("groups/list", "groups", groupService.list());
    }

    @RequestMapping("/edit")
    public ModelAndView addAndEditGroup() {
        return new ModelAndView("groups/edit", "specialties", specialtyService.list());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveGroup(@Valid Group group, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("groups/edit", "specialties", specialtyService.list());
        }
        groupService.save(group);
        request.getSession().setAttribute("win", "Группа сохранена");
        return new ModelAndView("redirect:/groups");
    }

    @RequestMapping(value = "/remove")
    public String removeGroup(Long id, HttpServletRequest request) {
        groupService.remove(id);
        request.getSession().setAttribute("win", "Группа удалена");
        return "redirect:/groups";
    }
}
