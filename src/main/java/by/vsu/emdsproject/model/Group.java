package by.vsu.emdsproject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Study_group")
public class Group implements AbstractEntity {

    private Long id;
    private String title;
    private Specialty specialty;
    private Set<Student> students;

    public Group() {
    }

    public Group(String title) {
        this.title = title;
    }

    public Group(String title, Specialty specialty) {
        this.title = title;
        this.specialty = specialty;
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

    @Column(name = "title", nullable = false, length = 10)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
