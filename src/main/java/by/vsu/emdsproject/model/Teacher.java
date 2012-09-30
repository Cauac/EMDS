package by.vsu.emdsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @Column(name = "id_teacher")
    private Long id;
    @Column(name = "fisrt_name", length = 25)
    private String fisrt_name;
    @Column(name = "last_name", length = 50)
    private String last_name;
    @Column(name = "middle_name", length = 30)
    private String middle_name;
    @Column(name = "rank", length = 20)
    private String rank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFisrt_name() {
        return fisrt_name;
    }

    public void setFisrt_name(String fisrt_name) {
        this.fisrt_name = fisrt_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
}
