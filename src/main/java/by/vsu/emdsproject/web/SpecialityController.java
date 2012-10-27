 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Max
 */
@Controller
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @RequestMapping(value = "/addSpeciality.htm", method = RequestMethod.POST)
    public ModelAndView addSpeciality(Speciality s, Errors errors) {
        if (errors.hasErrors()) {
            ModelAndView mav = new ModelAndView("addSpeciality");
            mav.addObject("errors", errors);
            return mav;
        }

        specialityService.addSpeciality(s);
        return new ModelAndView("redirect:/allSpecialities.htm");
    }

    @RequestMapping(value = "/addSpeciality.htm")
    public String addSpeciality() {
        return "speciality/addSpeciality";
    }

    @RequestMapping("/allSpecialities.htm")
    public ModelAndView allSpecialities() {
        List<Speciality> specialities = specialityService.listSpeciality();
        ModelAndView mav = new ModelAndView("speciality/specialityList");
        mav.addObject("specialities", specialities);
        return mav;
    }
}
