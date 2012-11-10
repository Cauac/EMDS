package by.vsu.emdsproject.common;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class EMDSContext {

    private static EMDSContext instance = new EMDSContext();

    private EMDSContext() {
    }

    public static EMDSContext getInstance() {
        return instance;
    }

    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
