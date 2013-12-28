package by.vsu.emdsproject.model;

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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(boolean defaultPassword) {
        this.defaultPassword = defaultPassword;
    }
}
