package by.vsu.emdsproject.model;

import java.util.HashSet;
import java.util.Set;

public class Role extends AbstractEntity {

    public static final String STUDENT = "ROLE_STUDENT";
    public static final String TEACHER = "ROLE_TEACHER";

    private String authority;
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
