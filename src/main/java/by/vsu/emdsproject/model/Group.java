package by.vsu.emdsproject.model;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Study_group")
public class Group {

    private Long id;
    private Long speciality_id;
    private String title;
    private Speciality speciality;
    private Set<Student> students;

    public Group() {
    }

    public Group(String title, Speciality speciality) {
        this.title = title;
        this.speciality = speciality;
    }

    public Group(String title, Long speciality_id) {
        this.title = title;
        this.speciality_id = speciality_id;
    }

    public Group(Long speciality_id, String title, Speciality speciality) {
        this.speciality_id = speciality_id;
        this.title = title;
        this.speciality = speciality;
    }

    @Id
    @Column(name = "id_group")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

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

    @Column(name = "speciality_id", nullable = false)
    public Long getSpeciality_id() {
        return speciality_id;
    }

    public void setSpeciality_id(Long speciality_id) {
        this.speciality_id = speciality_id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speciality_id", insertable=false, updatable=false)
    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @OneToMany
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
