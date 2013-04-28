package by.vsu.emdsproject.web.filter;

import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.service.TeacherService;
import by.vsu.emdsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Max
 */
@Component
public class AuthorisationSuccess implements AuthenticationSuccessHandler {

    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        // adding current user and his real name to the session
        String username = ((User) authentication.getPrincipal()).getUsername();
        by.vsu.emdsproject.model.User currentUser = userService.getByLogin(username);
        request.getSession().setAttribute("currentUser", currentUser);
        Teacher teacher = teacherService.read(currentUser.getPersonId());
        request.getSession().setAttribute("currentName", teacher);
        request.getSession().setAttribute("list", 1);

        // redirect (if need) to the request URL saved by Spring Security
        SavedRequest savedRequest =
                new HttpSessionRequestCache().getRequest(request, httpServletResponse);
        String redirectURL = (savedRequest != null) ? savedRequest.getRedirectUrl() : "";
        httpServletResponse.sendRedirect(redirectURL);
    }

}
