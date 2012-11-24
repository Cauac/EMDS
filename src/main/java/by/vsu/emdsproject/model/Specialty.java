package by.vsu.emdsproject.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "specialty")
public class Specialty extends AbstractEntity {

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

    public Specialty(Specialty s) {
        this.title = s.getTitle();
    }

    @Id
    @Column(name = "id_specialty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
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
