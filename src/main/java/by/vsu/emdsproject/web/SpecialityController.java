package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Speciality;
import by.vsu.emdsproject.service.SpecialityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @RequestMapping(value = "/addSpeciality", method = RequestMethod.POST)
    public ModelAndView addSpeciality(Speciality s, Errors errors) {
        if (errors.hasErrors()) {
            ModelAndView mav = new ModelAndView("addSpeciality");
            mav.addObject("errors", errors);
            return mav;
        }
        specialityService.addSpeciality(s);
        return new ModelAndView("redirect:/allSpecialities");
    }

    @RequestMapping(value = "/addSpeciality")
    public String addSpeciality() {
        return "speciality/addSpeciality";
    }

    @RequestMapping("/allSpecialities")
    public ModelAndView allSpecialities() {
        List<Speciality> specialities = specialityService.listSpeciality();
        ModelAndView mav = new ModelAndView("speciality/specialityList");
        mav.addObject("specialities", specialities);
        return mav;
    }
}
