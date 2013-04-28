package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.service.SpecialtyService;
import by.vsu.emdsproject.validation.SpecialtyValidator;
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
@RequestMapping("/specialties")
public class SpecialtiesController {

    @Autowired
    private SpecialtyService specialtyService;

    @ModelAttribute("specialty")
    public Specialty setSpecialty(Long id) {
        if (id != null) {
            return specialtyService.read(id);
        } else {
            return new Specialty();
        }
    }

    @InitBinder("specialty")
    public void initBinder(WebDataBinder binder) {
        // comment it to use JSR-303 validation
        binder.setValidator(new SpecialtyValidator());
    }

    @RequestMapping("")
    public ModelAndView specialties() {
        return new ModelAndView("/specialties/list", "specialties", specialtyService.list());
    }

    @RequestMapping(value = "/edit")
    public String addAndEditSpecialty() {
        return "/specialties/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveSpecialty(@Valid Specialty specialty, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/specialties/edit");
        }
        specialtyService.update(specialty);
        return new ModelAndView("redirect:/specialties");
    }

    @RequestMapping(value = "/remove")
    public String removeSpecialty(Long id) {
        specialtyService.remove(id);
        return "redirect:/specialties";
    }
}
