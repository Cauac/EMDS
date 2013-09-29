package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.service.SpecialtyService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    @RequestMapping("")
    public ModelAndView specialties() {
        return new ModelAndView("/specialties/list", "specialties", specialtyService.list());
    }

    @RequestMapping(value = "/edit")
    public String addAndEditSpecialty() {
        return "/specialties/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveSpecialty(@Valid Specialty specialty, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("/specialties/edit");
        }
        specialtyService.save(specialty);
        request.getSession().setAttribute("win", "Специальность сохранена.");
        return new ModelAndView("redirect:/specialties");
    }

    @RequestMapping(value = "/remove")
    public String removeSpecialty(Long id, HttpServletRequest request) {
        specialtyService.remove(id);
        request.getSession().setAttribute("win", "Специальность удалена.");
        return "redirect:/specialties";
    }
}
