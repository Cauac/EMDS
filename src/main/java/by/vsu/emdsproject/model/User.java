package by.vsu.emdsproject.model;

import javax.persistence.*;

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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "enabled")
    public int getEnabled() {
        return enabled;
    }

    @Column(name = "person_id")
    public Long getPersonId() {
        return personId;
    }

    @Column(name = "person_type")
    public String getPersonType() {
        return personType;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    @Column(name = "default_password")
    public boolean isDefaultPassword() {
        return defaultPassword;
    }


    public void setDefaultPassword(boolean defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

}
