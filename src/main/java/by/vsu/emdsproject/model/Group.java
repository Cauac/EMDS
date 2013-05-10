package by.vsu.emdsproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Study_group")
@JsonIgnoreProperties({"specialty", "students"})
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

    @NotEmpty(message = "Введите название")
    @Size(max = 10, message = "Не более 10 символов")
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
