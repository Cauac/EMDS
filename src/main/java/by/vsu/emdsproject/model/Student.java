package by.vsu.emdsproject.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<Document, DocumentInfo> getDocuments() {
        return documents;
    }

    public void setDocuments(Map<Document, DocumentInfo> documents) {
        this.documents = documents;
    }
}
