package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Role;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommonController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String welcome() {
        return "redirect:/students";
//        if (userService.getByLogin(EMDSContext.getInstance().getCurrentUser().getUsername()).getRole().getAuthority().equals(Role.TEACHER)) {
//            return "redirect:/";
//        }
//        return "fff";// "forward:start.jsp";
    }

    @RequestMapping(value = "/403")
    public String accessDenied() {
        return "error403";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user != null) {
            if (user.getRole().getAuthority().equals(Role.TEACHER)) {
                return "redirect:/";
            }
        }
        return "login";
    }

    @RequestMapping(value = "/loginfailed")
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        return "login";
    }

    @RequestMapping("/personal")
    public String personalPageView() {
        return "personal";
    }

    @RequestMapping(value = "/personal", method = RequestMethod.POST)
    public ModelAndView personalPageSave(String oldPass, String newPass, String confirm, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("personal");
        if (userService.changePassword(oldPass, newPass, confirm)) {
            request.getSession().removeAttribute("defPass");
            mav.addObject("win", "Пароль успешно изменен");
        } else {
            mav.addObject("fail", "Проверьте правильность ввода");
        }
        return mav;
    }

    @RequestMapping(value = "/exit")
    public String exit() {
        return "redirect:/j_spring_security_logout";
    }
}