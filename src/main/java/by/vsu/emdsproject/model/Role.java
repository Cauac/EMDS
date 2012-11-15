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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements AbstractEntity {

    private Long id;
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

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
