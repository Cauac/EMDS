package by.vsu.emdsproject.web;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

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

        request.getSession().setAttribute("currentUser", currentUser);

//        if (currentUser.getPersonType().equals("teacher")) {
//            request.getSession().setAttribute("currentPerson", teacherService.read(currentUser.getPersonId()).getLastName());
//        } else {
//            request.getSession().setAttribute("currentPerson", studentService.read(currentUser.getPersonId()).getLastName());
//        }


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
    public String login(ModelMap model, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("currentUser");

        if (user != null) {
            if (user.getRole().getAuthority().equals("ROLE_TEACHER")) {
                return "redirect:teacher";
            }
            if (user.getRole().getAuthority().equals("ROLE_STUDENT")) {
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

    @RequestMapping(value = "/exit")
    public String exit(ModelMap model) {
        return "redirect:/j_spring_security_logout";
    }
}
