package by.vsu.emdsproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
@JsonIgnoreProperties({"group", "questionnaire", "documents"})
public class Student extends Person {

    public static final String[] FACULTIES = new String[]{
            "Математический",
            "Физический",
            "Биологический",
            "Физической культуры и спорта",
            "Исторический",
            "Социальной педагогики и психологии",
            "Филологический",
            "Белорусской филологии и культры",
            "Юридический",
            "Художественно-графический",
            "Педагогический"};
    public static final String ABITURIENT = "abiturient";
    public static final String JUNIOR = "junior";
    public static final String OFFICER = "officer";
    public static final String RESERVE = "reserve";
    public static final String FAILED = "failed";
    public static final String DISMISSED = "dismissed";
    private Date birthDate;
    private Group group;
    private Questionnaire questionnaire;
    private String characteristic;
    private String rank;
    private String type;
    private Map<Document, DocumentInfo> documents = new HashMap<>();

    public Student() {
    }

    public Student(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
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

    @Size(max = 10000, message = "Не более 10 тысяч символов")
    @Column(name = "characteristic", length = 10000)
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

    @Column(name = "student_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "questionnaire_id")
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "student_documents",
            joinColumns =
            @JoinColumn(name = "student"),
            inverseJoinColumns =
            @JoinColumn(name = "document_info"))
    @MapKeyJoinColumn(name = "document")
    public Map<Document, DocumentInfo> getDocuments() {
        return documents;
    }

    public void setDocuments(Map<Document, DocumentInfo> documents) {
        this.documents = documents;
    }
}
