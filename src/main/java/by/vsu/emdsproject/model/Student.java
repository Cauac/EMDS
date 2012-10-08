package by.vsu.emdsproject.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student implements AbstractEntity{

    @Id
    @Column(name = "id_student")
    private Long id;
    @Column(name = "fisrt_name", length = 25)
    private String fisrt_name;
    @Column(name = "last_name", length = 50)
    private String last_name;
    @Column(name = "middle_name", length = 30)
    private String middle_name;
    @Column(name = "birth_year", length = 4)
    private String birthYear;
    @Column(name = "birth_place", length = 50)
    private String birthPlace;
    @ManyToOne
    @JoinColumn(name = "address")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "address")
    private Address parentAddress;
    @Column(name = "admission_year", length = 4)
    private String admissionYear;
    @Column(name = "recruitment_office", length = 40)
    private String recruitmentOffice;
    @Column(name = "faculty", length = 30)
    private String faculty;
    @Column(name = "course")
    private Integer course;
    @Column(name = "education", length = 100)
    private String education;
    @Column(name = "characteristic", length = 10000)
    private String characteristic;
    @Column(name = "service_start")
    @Temporal(value = TemporalType.DATE)
    private Date serviceStartDate;
    @Column(name = "service_end")
    @Temporal(value = TemporalType.DATE)
    private Date serviceEndDate;
    @Column(name = "education_start")
    @Temporal(value = TemporalType.DATE)
    private Date educationStartDate;
    @Column(name = "education_end")
    @Temporal(value = TemporalType.DATE)
    private Date educationEndDate;
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

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getParentAddress() {
        return parentAddress;
    }

    public void setParentAddress(Address parentAddress) {
        this.parentAddress = parentAddress;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public String getRecruitmentOffice() {
        return recruitmentOffice;
    }

    public void setRecruitmentOffice(String recruitmentOffice) {
        this.recruitmentOffice = recruitmentOffice;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public Date getEducationStartDate() {
        return educationStartDate;
    }

    public void setEducationStartDate(Date educationStartDate) {
        this.educationStartDate = educationStartDate;
    }

    public Date getEducationEndDate() {
        return educationEndDate;
    }

    public void setEducationEndDate(Date educationEndDate) {
        this.educationEndDate = educationEndDate;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
}
