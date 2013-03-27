package by.vsu.emdsproject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {

    public static final String STUDENT = "ROLE_STUDENT";
    public static final String TEACHER = "ROLE_TEACHER";

    private String authority;
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public Role(String auth) {
        authority = auth;
    }

    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "authority")
    public String getAuthority() {
        return authority;
    }

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
