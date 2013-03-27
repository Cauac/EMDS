package by.vsu.emdsproject.web;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.common.PasswordUtils;
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

    //    @Autowired
//    private TeacherService teacherService;
//    
//    @Autowired
//    private StudentService studentService;
    @RequestMapping(value = "/index")
    public String welcome(ModelMap model, HttpServletRequest request) {

        String username = EMDSContext.getInstance().getCurrentUser().getUsername();
        User currentUser = userService.getByLogin(username);

        if (currentUser.isDefaultPassword()) {
            request.getSession().setAttribute("defPass", "true");
        }

        request.getSession().setAttribute("currentUser", currentUser);

        if (currentUser.getRole().getAuthority().equals(Role.TEACHER)) {
            return "redirect:teacher";
        } else if (currentUser.getRole().getAuthority().equals(Role.STUDENT)) {
            return "redirect:student";
        }

        return "forward:index.jsp";
    }

    @RequestMapping(value = "/403")
    public String accessDenied(ModelMap model) {
        return "error403";
    }

    @RequestMapping(value = "/login")
    public String login(ModelMap model, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("currentUser");

        if (user != null) {
            if (user.getRole().getAuthority().equals(Role.TEACHER)) {
                return "redirect:teacher";
            }
            if (user.getRole().getAuthority().equals(Role.STUDENT)) {
                return "redirect:student";
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
    public String logout(ModelMap model) {
        return "login";
    }

    @RequestMapping("/personal")
    public String personalPageView() {
        return "personal";
    }

    @RequestMapping(value = "/personal", method = RequestMethod.POST)
    public ModelAndView personalPageSave(String oldPass, String newPass, String confirm, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("personal");
        User u = userService.getByLogin(EMDSContext.getInstance().getCurrentUser().getUsername());
        if (u.getPassword().equals(PasswordUtils.encode(oldPass)) && newPass.equals(confirm)) {
            u.setPassword(PasswordUtils.encode(newPass));
            request.getSession().removeAttribute("defPass");
            u.setDefaultPassword(false);
            userService.update(u);
            mav.addObject("win", "Пароль успешно изменен");
        } else {
            mav.addObject("fail", "Проверьте правильность ввода");
        }
        return mav;
    }

    @RequestMapping(value = "/exit")
    public String exit(ModelMap model) {
        return "redirect:/j_spring_security_logout";
    }
}