package by.vsu.emdsproject.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements AbstractEntity {

    public static final String STUDENT = "student";
    public static final String TEACHER = "teacher";
    public static final int ENABLED = 1;
    public static final int DISABLED = 0;
    private Long id;
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
    @Override
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
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
