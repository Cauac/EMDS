package by.vsu.emdsproject.web.authentication;

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

@Component
public class AuthorisationSuccess implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        // adding current user and his real name to the session
        String username = ((User) authentication.getPrincipal()).getUsername();
        System.out.println(username);
        //request.getSession().setAttribute("list", 1);

        // redirect (if need) to the request URL saved by Spring Security
        SavedRequest savedRequest =
                new HttpSessionRequestCache().getRequest(request, httpServletResponse);
        String redirectURL = (savedRequest != null) ? savedRequest.getRedirectUrl() : "";
        httpServletResponse.sendRedirect(redirectURL);
    }

}
