package by.vsu.emdsproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student extends Person {

    public static final String STUDENT = "student";
    public static final String ABITURIENT = "abiturient";

    private Date birthDate;
    private Group group;
    private Questionnaire questionnaire;
    private String characteristic;
    private String rank;
    private DocumentsBringing documents;

    public Student() {
    }

    @Id
    @Column(name = "id_student")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
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

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }

    @Column(name = "characteristic")
    public String getCharacteristic() {
        return characteristic;
    }

    @Column(name = "rank")
    public String getRank() {
        return rank;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionnaire_id")
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "documents_id")
    public DocumentsBringing getDocuments() {
        return documents;
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

    public void setDocuments(DocumentsBringing documents) {
        this.documents = documents;
    }

    public void toStudent() {
        rank = STUDENT;
    }

    public void toAbiturient() {
        rank = ABITURIENT;
    }

}
