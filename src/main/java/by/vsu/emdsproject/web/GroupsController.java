package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.propertyeditor.SpecialtyEditor;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.SpecialtyService;
import by.vsu.emdsproject.validation.GroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/teacher/groups")
public class GroupsController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private SpecialtyService specialtyService;

    @ModelAttribute("group")
    public Group setGroup(Long id) {
        if (id != null) {
            return groupService.read(id);
        } else {
            return new Group();
        }
    }

    @InitBinder("group")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Specialty.class, "specialty", new SpecialtyEditor(specialtyService));

        // comment it to use JSR-303 validation
        binder.setValidator(new GroupValidator());
    }

    @RequestMapping("")
    public ModelAndView groups() {
        return new ModelAndView("teacher/groups/list", "groups", groupService.list());
    }

    @RequestMapping("/add")
    public ModelAndView addGroup() {
        return new ModelAndView("teacher/groups/edit", "specialties", specialtyService.list());
    }

    @RequestMapping("/edit")
    public ModelAndView editGroup() {
        return new ModelAndView("teacher/groups/edit", "specialties", specialtyService.list());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveGroup(@Valid Group group, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/teacher/groups/edit", "specialties", specialtyService.list());
        }
        groupService.update(group);
        return new ModelAndView("redirect:/teacher/groups");
    }

    @RequestMapping(value = "/remove")
    public String removeGroup(Long id) {
        groupService.remove(id);
        return "redirect:/teacher/groups";
    }
}
