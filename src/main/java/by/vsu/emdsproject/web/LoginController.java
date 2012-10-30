package by.vsu.emdsproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/welcome")
	public String welcome(ModelMap model) {
		return "index";
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
