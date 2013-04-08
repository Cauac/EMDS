package by.vsu.emdsproject.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "student")
public class Student extends Person {

    public static final String STUDENT = "student";
    public static final String ABITURIENT = "abiturient";
    private Long id;
    private Date birthDate;
    private Group group;
    private Questionnaire questionnaire;
    private String characteristic;
    private String rank;
    private Map<Document, DocumentInfo> documents;

    public Student() {
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

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Column(name = "characteristic")
    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    @Column(name = "rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionnaire_id")
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    @ElementCollection(fetch = FetchType.LAZY, targetClass = DocumentInfo.class)
    @CollectionTable(name = "brought_documents", joinColumns = @JoinColumn(name = "student_id"))
    @MapKeyClass(value = by.vsu.emdsproject.model.Document.class)
    @MapKeyColumn(name = "document_id")
    @Column(name = "document_info_id")
    public Map<Document, DocumentInfo> getDocuments() {
        return documents;
    }

    public void setDocuments(Map<Document, DocumentInfo> documents) {
        this.documents = documents;
    }
}
