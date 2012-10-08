package by.vsu.emdsproject.model;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject implements AbstractEntity{

    private Long id;
    private String description;

    public Subject() {
    }
    
    public Subject(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "id_subject")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "title", nullable = false, length = 100)
    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
