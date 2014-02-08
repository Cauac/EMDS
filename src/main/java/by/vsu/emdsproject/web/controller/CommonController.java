package by.vsu.emdsproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping(value = "/")
    public String index() {
        return "/resources/html/index.html";
    }

    @RequestMapping(value = "/403")
    public String accessDenied() {
        return "error403";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "/resources/html/login.html";
    }

    @RequestMapping(value = "/loginfailed")
    public String loginerror() {
        return "/resources/html/loginfailed.html";
    }

    @RequestMapping("/personal")
    public String personalPageView() {
        return "personal";
    }

    @RequestMapping(value = "/developers")
    public String developers() {
        return "/support/developers";
    }
}