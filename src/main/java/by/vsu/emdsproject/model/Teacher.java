package by.vsu.emdsproject.model;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher extends Person {

    private Long id;
    private String rank;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
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

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "middle_name", nullable = false)
    public String getMiddleName() {
        return middleName;
    }

    @Column(name = "rank", length = 20)
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
