package by.vsu.emdsproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    public static final String STUDENT = "student";
    public static final String TEACHER = "teacher";
    public static final int ENABLED = 1;
    public static final int DISABLED = 0;
    private Long personId;
    private String personType;
    private String login;
    private String password;
    private int enabled;
    private Role role;
    private boolean defaultPassword;


    public User() {
    }

    public User(Long personId, String personType, String login, String password, int enabled, Role role) {
        this.personId = personId;
        this.personType = personType;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    @NotNull
    @Size(max = 52)
    @Column(name = "login", length = 52)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @NotEmpty(message = "Пустой пароль")
    @Size(min = 5, max = 64, message = "От 5 до 64 символов")
    @Column(name = "password", length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "enabled")
    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Column(name = "person_id")
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Column(name = "person_type")
    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "default_password")
    public boolean isDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(boolean defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

}
