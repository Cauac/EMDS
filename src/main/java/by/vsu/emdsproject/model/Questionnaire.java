package by.vsu.emdsproject.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "questionnaire")
public class Questionnaire implements AbstractEntity {

    private Long id;
    private String birthPlace;
    private String nationality;
    private String passportNumber;
    private Address address;
    private String mobileTel;
    private String homeTel;
    private String admissionYear;
    private String faculty;
    private String studySpecialty;
    private Integer course;
    private String studyGroup;
    private float studyProgress;
    private String curator;
    private String curatorTel;
    private String education;
    private Date educationStartDate;
    private Date educationEndDate;
    private String educationType;
    private String familyStatus;
    private String mother;
    private String father;
    private Address parentAddress;
    private String passportOffice;
    private String recruitmentOffice;
    private String parentTel;
    private String educationBefore;
    private String facultyPublicLife;
    private String hobby;
    private String publicOrganization;
    private String employment;
    private String howDidYouHearAbout;
    private String desireToContinue;
    private String thinkAboutStudy;
    private String thinkAboutDuty;
    private Date dutyStart;
    private Date dutyEnd;

    public Questionnaire() {
    }

    @Id
    @Column(name = "id_questionnaire")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "birth_place", length = 50)
    public String getBirthPlace() {
        return birthPlace;
    }

    @Column(name = "nationality", length = 20)
    public String getNationality() {
        return nationality;
    }

    @Column(name = "passport_number", length = 10)
    public String getPassportNumber() {
        return passportNumber;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    public Address getAddress() {
        return address;
    }

    @Column(name = "mobile_tel", length = 10)
    public String getMobileTel() {
        return mobileTel;
    }

    @Column(name = "home_tel", length = 10)
    public String getHomeTel() {
        return homeTel;
    }

    @Column(name = "admission_year", length = 4)
    public String getAdmissionYear() {
        return admissionYear;
    }

    @Column(name = "faculty", length = 30)
    public String getFaculty() {
        return faculty;
    }

    @Column(name = "study_specialty", length = 30)
    public String getStudySpecialty() {
        return studySpecialty;
    }

    @Column(name = "course")
    public Integer getCourse() {
        return course;
    }

    @Column(name = "study_group", length = 10)
    public String getStudyGroup() {
        return studyGroup;
    }

    @Column(name = "study_progress")
    public float getStudyProgress() {
        return studyProgress;
    }

    @Column(name = "curator", length = 30)
    public String getCurator() {
        return curator;
    }

    @Column(name = "curator_tel", length = 10)
    public String getCuratorTel() {
        return curatorTel;
    }

    @Column(name = "education", length = 100)
    public String getEducation() {
        return education;
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

    @Column(name = "education_type", length = 20)
    public String getEducationType() {
        return educationType;
    }

    @Column(name = "family_status", length = 20)
    public String getFamilyStatus() {
        return familyStatus;
    }

    @Column(name = "mother", length = 100)
    public String getMother() {
        return mother;
    }

    @Column(name = "father", length = 100)
    public String getFather() {
        return father;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_address_id")
    public Address getParentAddress() {
        return parentAddress;
    }

    @Column(name = "passport_office", length = 100)
    public String getPassportOffice() {
        return passportOffice;
    }

    @Column(name = "recruitment_office", length = 100)
    public String getRecruitmentOffice() {
        return recruitmentOffice;
    }

    @Column(name = "parent_tel", length = 10)
    public String getParentTel() {
        return parentTel;
    }

    @Column(name = "education_before", length = 100)
    public String getEducationBefore() {
        return educationBefore;
    }

    @Column(name = "faculty_public_life", length = 100)
    public String getFacultyPublicLife() {
        return facultyPublicLife;
    }

    @Column(name = "hobby", length = 100)
    public String getHobby() {
        return hobby;
    }

    @Column(name = "public_organization", length = 100)
    public String getPublicOrganization() {
        return publicOrganization;
    }

    @Column(name = "employment", length = 100)
    public String getEmployment() {
        return employment;
    }

    @Column(name = "how_did_you_hear_about", length = 100)
    public String getHowDidYouHearAbout() {
        return howDidYouHearAbout;
    }

    @Column(name = "desire_to_continue", length = 100)
    public String getDesireToContinue() {
        return desireToContinue;
    }

    @Column(name = "think_about_study", length = 100)
    public String getThinkAboutStudy() {
        return thinkAboutStudy;
    }

    @Column(name = "think_about_duty", length = 100)
    public String getThinkAboutDuty() {
        return thinkAboutDuty;
    }

    @Column(name = "duty_start")
    @Temporal(TemporalType.DATE)
    public Date getDutyStart() {
        return dutyStart;
    }

    @Column(name = "duty_end")
    @Temporal(TemporalType.DATE)
    public Date getDutyEnd() {
        return dutyEnd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setStudySpecialty(String specialty) {
        this.studySpecialty = specialty;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public void setStudyGroup(String studyGroup) {
        this.studyGroup = studyGroup;
    }

    public void setStudyProgress(float studyProgress) {
        this.studyProgress = studyProgress;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public void setCuratorTel(String curatorTel) {
        this.curatorTel = curatorTel;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setEducationStartDate(Date educationStartDate) {
        this.educationStartDate = educationStartDate;
    }

    public void setEducationEndDate(Date educationEndDate) {
        this.educationEndDate = educationEndDate;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setParentAddress(Address parentAddress) {
        this.parentAddress = parentAddress;
    }

    public void setPassportOffice(String passportOffice) {
        this.passportOffice = passportOffice;
    }

    public void setRecruitmentOffice(String recruitmentOffice) {
        this.recruitmentOffice = recruitmentOffice;
    }

    public void setParentTel(String parentTel) {
        this.parentTel = parentTel;
    }

    public void setEducationBefore(String educationBefore) {
        this.educationBefore = educationBefore;
    }

    public void setFacultyPublicLife(String facultyPublicLife) {
        this.facultyPublicLife = facultyPublicLife;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setPublicOrganization(String publicOrganization) {
        this.publicOrganization = publicOrganization;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public void setHowDidYouHearAbout(String howDidYouHearAbout) {
        this.howDidYouHearAbout = howDidYouHearAbout;
    }

    public void setDesireToContinue(String desireToContinue) {
        this.desireToContinue = desireToContinue;
    }

    public void setThinkAboutStudy(String thinkAboutStudy) {
        this.thinkAboutStudy = thinkAboutStudy;
    }

    public void setThinkAboutDuty(String thinkAboutDuty) {
        this.thinkAboutDuty = thinkAboutDuty;
    }

    public void setDutyStart(Date dutyStart) {
        this.dutyStart = dutyStart;
    }

    public void setDutyEnd(Date dutyEnd) {
        this.dutyEnd = dutyEnd;
    }
}
