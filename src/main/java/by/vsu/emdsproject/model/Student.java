package by.vsu.emdsproject.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student implements AbstractEntity {

    private Long id;
    private String fisrtName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private Group group;
    private Questionnaire questionnaire;
    private String characteristic;
    private String rank;

    public Student() {
    }

    @Id
    @Column(name = "id_student")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "fisrt_name", nullable = false, length = 25)
    public String getFisrtName() {
        return fisrtName;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "middle_name", nullable = false, length = 30)
    public String getMiddleName() {
        return middleName;
    }

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }

    @Column(name = "characteristic", length = 10000)
    public String getCharacteristic() {
        return characteristic;
    }

    @Column(name = "rank", length = 20)
    public String getRank() {
        return rank;
    }

    //@Column(name = "questionnaire")
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
    
}
