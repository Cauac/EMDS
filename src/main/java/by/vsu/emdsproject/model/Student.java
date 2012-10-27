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
    private String birthYear;
    private String birthPlace;
    private Address address;
    private Address parentAddress;
    private Group group;
    private String admissionYear;
    private String recruitmentOffice;
    private String faculty;
    private Integer course;
    private String education;
    private String characteristic;
    private Date serviceStartDate;
    private Date serviceEndDate;
    private Date educationStartDate;
    private Date educationEndDate;
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

    @Column(name = "birth_year", nullable = false, length = 4)
    public String getBirthYear() {
        return birthYear;
    }

    @Column(name = "birth_place", length = 50)
    public String getBirthPlace() {
        return birthPlace;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Address getAddress() {
        return address;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Address getParentAddress() {
        return parentAddress;
    }
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    public Group getGroup() {
        return group;
    }

    @Column(name = "admission_year", length = 4)
    public String getAdmissionYear() {
        return admissionYear;
    }

    @Column(name = "recruitment_office", length = 40)
    public String getRecruitmentOffice() {
        return recruitmentOffice;
    }

    @Column(name = "faculty", length = 30)
    public String getFaculty() {
        return faculty;
    }

    @Column(name = "course")
    public Integer getCourse() {
        return course;
    }

    @Column(name = "education", length = 100)
    public String getEducation() {
        return education;
    }

    @Column(name = "characteristic", length = 10000)
    public String getCharacteristic() {
        return characteristic;
    }

    @Column(name = "service_start")
    @Temporal(TemporalType.DATE)
    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    @Column(name = "service_end")
    @Temporal(TemporalType.DATE)
    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    @Column(name = "education_start")
    @Temporal(TemporalType.DATE)
    public Date getEducationStartDate() {
        return educationStartDate;
    }

    @Column(name = "education_end")
    @Temporal(TemporalType.DATE)
    public Date getEducationEndDate() {
        return educationEndDate;
    }

    @Column(name = "rank", length = 20)
    public String getRank() {
        return rank;
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

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }

    public void setParentAddress(Address parentAddress) {
        this.parentAddress = parentAddress;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public void setRecruitmentOffice(String recruitmentOffice) {
        this.recruitmentOffice = recruitmentOffice;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public void setEducationStartDate(Date educationStartDate) {
        this.educationStartDate = educationStartDate;
    }

    public void setEducationEndDate(Date educationEndDate) {
        this.educationEndDate = educationEndDate;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
