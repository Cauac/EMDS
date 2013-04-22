package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class SpecialtiesController {

    @Autowired
    private SpecialtyService specialtyService;

    @RequestMapping("/specialties")
    public ModelAndView specialties() {
        ModelAndView mav = new ModelAndView("teacher/specialties/list");
        List<Specialty> specialties = specialtyService.list();
        mav.addObject("specialties", specialties);
        return mav;
    }

    @RequestMapping(value = "/specialties/add")
    public String addSpecialty() {
        return "teacher/specialties/add";
    }

    @RequestMapping(value = "/specialties/add", method = RequestMethod.POST)
    public ModelAndView addSpecialty(Specialty specialty, Errors errors) {
        if (errors.hasErrors()) {
            ModelAndView mav = new ModelAndView("teacher/specialties/add");
            mav.addObject("errors", errors);
            return mav;
        }
        specialtyService.add(specialty);
        return new ModelAndView("redirect:/teacher/specialties");
    }

    @RequestMapping(value = "/specialties/edit")
    public ModelAndView editSpecialty(Long id) {
        ModelAndView mav = new ModelAndView("teacher/specialties/edit");
        mav.addObject("specialty", specialtyService.read(id));
        return mav;
    }

    @RequestMapping(value = "/specialties/edit", method = RequestMethod.POST)
    public ModelAndView editSpecialty(Specialty specialty) {
        specialtyService.update(specialty);
        return new ModelAndView("redirect:/teacher/specialties");
    }

    @RequestMapping(value = "/specialties/remove")
    public String removeSpecialty(String id) {
        specialtyService.remove(Long.parseLong(id));
        return "redirect:/teacher/specialties";
    }
}
