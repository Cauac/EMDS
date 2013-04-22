package by.vsu.emdsproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

// todo: add criterias(or just repository methods) to get students by group, specialty, etc.)
@Entity
@Table(name = "Study_group")
public class Group extends AbstractEntity {

    private String title;
    private Specialty specialty;
    private Set<Student> students = new HashSet<Student>();

    public Group() {
    }

    public Group(String title) {
        this.title = title;
    }

    public Group(String title, Specialty specialty) {
        this.title = title;
        this.specialty = specialty;
    }

    @NotNull
    @Size(max = 10)
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
