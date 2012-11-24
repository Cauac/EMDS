package by.vsu.emdsproject.model;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String middleName;
    private String rank;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Id
    @Column(name = "id_teacher")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "first_name", nullable = false, length = 25)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "middle_name", nullable = false, length = 30)
    public String getMiddleName() {
        return middleName;
    }

    @Column(name = "rank", length = 20)
    public String getRank() {
        return rank;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
