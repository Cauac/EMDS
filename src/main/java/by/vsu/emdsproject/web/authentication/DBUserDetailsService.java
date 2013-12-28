package by.vsu.emdsproject.web.authentication;

import by.vsu.emdsproject.dao.TeacherDAO;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class DBUserDetailsService implements UserDetailsService {

    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    TeacherDAO teacherDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DBObject dbTeacher = teacherDAO.read(username);

        if (dbTeacher == null) {
            if("admin".equals(username)){
                Collection<GrantedAuthority> userAuthorities = new ArrayList<GrantedAuthority>();
                userAuthorities.add(new SimpleGrantedAuthority(ROLE_USER));
                return new User(username, "admin", true, true, true, true, userAuthorities);
            }
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }

        Collection<GrantedAuthority> userAuthorities = new ArrayList<GrantedAuthority>();
        userAuthorities.add(new SimpleGrantedAuthority(ROLE_USER));

        String password = dbTeacher.get("password").toString();

        return new User(username, password, true, true, true, true, userAuthorities);
    }
}
