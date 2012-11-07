package by.vsu.emdsproject.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements AbstractEntity {

    private Long id;
    private Long personId;
    private String personType;
    private String login;
    private String password;
    private int enabled;
    private Set<Role> roles = new HashSet<Role>();

    public User() {
    }

    public User(Long id, Long personId, String personType, String login, String password, int enabled) {
        this.id = id;
        this.personId = personId;
        this.personType = personType;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
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

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = {
        @JoinColumn(name = "user_id")},
    inverseJoinColumns = {
        @JoinColumn(name = "role_id")})
    public Set<Role> getRoles() {
        return roles;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setId(Long id) {
        this.id = id;
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
