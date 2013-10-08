package by.vsu.emdsproject.config;

import by.vsu.emdsproject.common.PasswordUtils;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * @author Max
 */
@Component("emdsAuthProvider")
public class EMDSAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String username = String.valueOf(a.getPrincipal());
        String password = String.valueOf(a.getCredentials());
        User u = userRepository.findByLogin(username);
        if (u == null || !PasswordUtils.encode(u.getPassword()).equals(password)) {
            throw new BadCredentialsException("Bad Credentials");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(u.getRole().getAuthority()));
        return new UsernamePasswordAuthenticationToken(u, null, authorities);
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }

}
