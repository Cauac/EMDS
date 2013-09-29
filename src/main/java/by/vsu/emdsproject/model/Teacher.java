package by.vsu.emdsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher extends Person {

    private String rank;
    private Boolean isChief = false;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
    }

    @Column(name = "ischief", nullable = false)
    public Boolean getChief() {
        return isChief;
    }

    public void setChief(Boolean chief) {
        isChief = chief;
    }

    @Column(name = "rank", length = 20, nullable = false)
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
