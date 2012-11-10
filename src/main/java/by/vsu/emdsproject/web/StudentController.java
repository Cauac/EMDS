package by.vsu.emdsproject.web;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public ModelAndView mainPage () {
        ModelAndView mav = new ModelAndView("student/studentMain");
        mav.addObject("currUser", EMDSContext.getInstance().getCurrentUser().getUsername());
        return mav;
    }
    
}
