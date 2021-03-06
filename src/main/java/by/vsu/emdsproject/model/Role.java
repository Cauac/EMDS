package by.vsu.emdsproject.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {

    public static final String STUDENT = "ROLE_STUDENT";
    public static final String TEACHER = "ROLE_TEACHER";

    private String authority;
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    @NotEmpty(message = "Обязательное поле")
    @Size(max = 45, message = "Не более 45 символов")
    @Column(name = "authority", length = 45)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
