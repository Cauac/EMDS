package by.vsu.emdsproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.validation.Valid;

@Entity
@Table(name = "questionnaire")
public class Questionnaire extends AbstractEntity {

    private String birthPlace;
    private String nationality;
    private String passportNumber;
    private String personalNumber;
    private Address address;
    private String mobileTel;
    private String homeTel;
    private String admissionYear;
    private String faculty;
    private String studySpecialty;
    private String course;
    private String studyGroup2;
    private String studyGroup3;
    private String studyGroup4;
    private String studyGroup5;
    private String studyProgress;
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
    private String duty;
    @JsonBackReference
    private Student student;

    public Questionnaire() {
    }

    @Size(max = 50, message = "Не более 50 символов")
    @Column(name = "birth_place", length = 50)
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Size(max = 20, message = "Не более 20 символов")
    @Column(name = "nationality", length = 20)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Size(max = 10, message = "Не более 10 символов")
    @Column(name = "passport_number", length = 10)
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Size(max = 20, message = "Не более 20 символов")
    @Column(name = "personal_number", length = 20)
    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Size(max = 10, message = "Не более 10 символов")
    @Column(name = "mobile_tel", length = 10)
    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    @Size(max = 10, message = "Не более 10 символов")
    @Column(name = "home_tel", length = 10)
    public String getHomeTel() {
        return homeTel;
    }

    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }

    @Size(max = 4, message = "Не более 4 символов")
    @Column(name = "admission_year", length = 4)
    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    @Size(max = 30, message = "Не более 30 символов")
    @Column(name = "faculty", length = 30)
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Size(max = 30, message = "Не более 30 символов")
    @Column(name = "specialty", length = 30)
    public String getStudySpecialty() {
        return studySpecialty;
    }

    public void setStudySpecialty(String specialty) {
        this.studySpecialty = specialty;
    }

    @Size(max = 10, message = "Не более 10 символов")
    @Column(name = "course", length = 10)
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Size(max = 10, message = "Не более 10 символов")
    @Column(name = "study_group_2", length = 10)
    public String getStudyGroup2() {
        return studyGroup2;
    }

    public void setStudyGroup2(String studyGroup) {
        this.studyGroup2 = studyGroup;
    }

    @Size(max = 10, message = "Не более 10 символов")
    @Column(name = "study_group_3", length = 10)
    public String getStudyGroup3() {
        return studyGroup3;
    }

    public void setStudyGroup3(String studyGroup) {
        this.studyGroup3 = studyGroup;
    }

    @Size(max = 10, message = "Не более 10 символов")
    @Column(name = "study_group_4", length = 10)
    public String getStudyGroup4() {
        return studyGroup4;
    }

    public void setStudyGroup4(String studyGroup) {
        this.studyGroup4 = studyGroup;
    }

    @Size(max = 10, message = "Не более 10 символов")
    @Column(name = "study_group_5", length = 10)
    public String getStudyGroup5() {
        return studyGroup5;
    }

    public void setStudyGroup5(String studyGroup) {
        this.studyGroup5 = studyGroup;
    }

    @Size(max = 20, message = "Не более 20 символов")
    @Column(name = "study_progress", length = 20)
    public String getStudyProgress() {
        return studyProgress;
    }

    public void setStudyProgress(String studyProgress) {
        this.studyProgress = studyProgress;
    }

    @Size(max = 30, message = "Не более 30 символов")
    @Column(name = "curator", length = 30)
    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    @Size(max = 10, message = "Не более 10 символов")
    @Column(name = "curator_tel", length = 10)
    public String getCuratorTel() {
        return curatorTel;
    }

    public void setCuratorTel(String curatorTel) {
        this.curatorTel = curatorTel;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "education", length = 100)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Column(name = "education_start")
    @Temporal(TemporalType.DATE)
    public Date getEducationStartDate() {
        return educationStartDate;
    }

    public void setEducationStartDate(Date educationStartDate) {
        this.educationStartDate = educationStartDate;
    }

    @Column(name = "education_end")
    @Temporal(TemporalType.DATE)
    public Date getEducationEndDate() {
        return educationEndDate;
    }

    public void setEducationEndDate(Date educationEndDate) {
        this.educationEndDate = educationEndDate;
    }

    @Size(max = 20, message = "Не более 20 символов")
    @Column(name = "education_type", length = 20)
    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    @Size(max = 20, message = "Не более 20 символов")
    @Column(name = "family_status", length = 20)
    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "mother", length = 100)
    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "father", length = 100)
    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parents_address_id")
    public Address getParentAddress() {
        return parentAddress;
    }

    public void setParentAddress(Address parentAddress) {
        this.parentAddress = parentAddress;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "passport_office", length = 100)
    public String getPassportOffice() {
        return passportOffice;
    }

    public void setPassportOffice(String passportOffice) {
        this.passportOffice = passportOffice;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "recruitment_office", length = 100)
    public String getRecruitmentOffice() {
        return recruitmentOffice;
    }

    public void setRecruitmentOffice(String recruitmentOffice) {
        this.recruitmentOffice = recruitmentOffice;
    }

    @Size(max = 50, message = "Не более 50 символов")
    @Column(name = "parent_tel", length = 50)
    public String getParentTel() {
        return parentTel;
    }

    public void setParentTel(String parentTel) {
        this.parentTel = parentTel;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "education_before", length = 100)
    public String getEducationBefore() {
        return educationBefore;
    }

    public void setEducationBefore(String educationBefore) {
        this.educationBefore = educationBefore;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "faculty_public_life", length = 100)
    public String getFacultyPublicLife() {
        return facultyPublicLife;
    }

    public void setFacultyPublicLife(String facultyPublicLife) {
        this.facultyPublicLife = facultyPublicLife;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "hobby", length = 100)
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "public_organization", length = 100)
    public String getPublicOrganization() {
        return publicOrganization;
    }

    public void setPublicOrganization(String publicOrganization) {
        this.publicOrganization = publicOrganization;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "employment", length = 100)
    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "how_did_you_hear_about", length = 100)
    public String getHowDidYouHearAbout() {
        return howDidYouHearAbout;
    }

    public void setHowDidYouHearAbout(String howDidYouHearAbout) {
        this.howDidYouHearAbout = howDidYouHearAbout;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "desire_to_continue", length = 100)
    public String getDesireToContinue() {
        return desireToContinue;
    }

    public void setDesireToContinue(String desireToContinue) {
        this.desireToContinue = desireToContinue;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "think_about_study", length = 100)
    public String getThinkAboutStudy() {
        return thinkAboutStudy;
    }

    public void setThinkAboutStudy(String thinkAboutStudy) {
        this.thinkAboutStudy = thinkAboutStudy;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "think_about_duty", length = 100)
    public String getThinkAboutDuty() {
        return thinkAboutDuty;
    }

    public void setThinkAboutDuty(String thinkAboutDuty) {
        this.thinkAboutDuty = thinkAboutDuty;
    }

    @Size(max = 100, message = "Не более 100 символов")
    @Column(name = "duty", length = 100)
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @OneToOne(mappedBy = "questionnaire", fetch = FetchType.LAZY)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
