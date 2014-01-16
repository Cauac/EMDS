package by.vsu.emdsproject.web.authentication;

import by.vsu.emdsproject.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class EmptyBaseUserDetailsService implements UserDetailsService {

    public static final String ROLE_USER = "ROLE_USER";
    public static final String BACK_DOOR_USER_NAME = "admin";
    public static final String BACK_DOOR_PASSWORD = "admin";

    @Autowired
    TeacherDAO teacherDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!BACK_DOOR_USER_NAME.equals(username)) {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }

        if (teacherDAO.getCount() > 0) {
            throw new UsernameNotFoundException("Use teacher credentials!");
        }

        Collection<GrantedAuthority> userAuthorities = new ArrayList<GrantedAuthority>();
        userAuthorities.add(new SimpleGrantedAuthority(ROLE_USER));

        return new User(username, BACK_DOOR_PASSWORD, true, true, true, true, userAuthorities);
    }
}
