package by.vsu.emdsproject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialty")
public class Specialty implements AbstractEntity {

    private Long id;
    private String title;
    private Set<Group> groups = new HashSet<Group>();

    public Specialty() {
    }

    public Specialty(Long id) {
        this.id = id;
    }

    public Specialty(String title) {
        this.title = title;
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

    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
