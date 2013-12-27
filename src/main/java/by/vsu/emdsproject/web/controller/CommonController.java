package by.vsu.emdsproject.web.controller;

import by.vsu.emdsproject.model.Role;
import by.vsu.emdsproject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommonController {

    @RequestMapping(value = "/index")
    public String welcome() {
        return "/resources/html/index.html";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "/resources/html/index.html";
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
        return "/resources/html/login.html";
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

    @RequestMapping(value = "/exit")
    public String exit() {
        return "redirect:/j_spring_security_logout";
    }

    @RequestMapping(value = "/config")
    public String config() {
        return "/support/config";
    }

    @RequestMapping(value = "/developers")
    public String developers() {
        return "/support/developers";
    }
}