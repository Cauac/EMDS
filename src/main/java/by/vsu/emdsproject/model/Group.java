package by.vsu.emdsproject.model;

import java.util.HashSet;
import java.util.Set;

public class Group extends AbstractEntity {

    private String title;
    private Specialty specialty;
    private Set<Student> students = new HashSet<>();

    public Group() {
    }

    public Group(String title) {
        this.title = title;
    }

    public Group(String title, Specialty specialty) {
        this.title = title;
        this.specialty = specialty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
