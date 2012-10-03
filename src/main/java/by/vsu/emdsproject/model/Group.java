package by.vsu.emdsproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Study_group")
public class Group {

    private Long id;
    private String title;
    private Speciality speciality_id;

    public Group() {
    }

    public Group(String title, Speciality speciality) {
        this.title = title;
        this.speciality_id = speciality;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speciality_id")
    public Speciality getSpeciality() {
        return speciality_id;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality_id = speciality;
    }   
    
}
