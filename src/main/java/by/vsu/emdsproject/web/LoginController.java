package by.vsu.emdsproject.web;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/index")
    public String welcome(ModelMap model) {
        String username = EMDSContext.getInstance().getCurrentUser().getUsername();
        User currentUser = userService.getByLogin(username);
        if (currentUser.getRole().getAuthority().equals("ROLE_TEACHER")) {
            return "redirect:teacher";
        }
        if (currentUser.getRole().getAuthority().equals("ROLE_STUDENT")) {
            return "redirect:student";
        }
        return "forward:index.jsp";
    }

    @RequestMapping(value = "/403")
    public String accessDenied(ModelMap model) {
        return "error403";
    }

    @RequestMapping(value = "/login")
    public String login(ModelMap model) {
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
}
