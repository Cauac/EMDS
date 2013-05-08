package by.vsu.emdsproject.report.aspose;

import by.vsu.emdsproject.model.Student;
import com.aspose.words.*;

import java.text.SimpleDateFormat;

public class PersonCardReport {

    private Student student;

    public static final String temlateName = "/home/anton/PersonCard.docx";

    public static class Parameter {

        public static final String CARD_NUMBER = "cardNumber";
        public static final String ADMISSION_YEAR = "admissionYear";
        public static final String FIO = "fio";
        public static final String BIRTH_YEAR = "birthYear";
        public static final String BIRTH_PLACE = "birthPlace";
        public static final String RECRUIT_OFFICE = "recruitOffice";
        public static final String FACULTY = "faculty";
        public static final String EDUCATION = "education";
        public static final String DUTY = "duty";
        public static final String EDUCATION_START = "educationStart";
        public static final String EDUCATION_END = "educationEnd";
        public static final String RANK = "rank";
        public static final String PARENT_ADDRESS = "parentAddress";
        public static final String ADDRESS = "address";
    }

    public PersonCardReport(Student student) {
        this.student = student;
    }

    public Document generate() throws Exception {
        Document document = new Document(temlateName);
        Range range = document.getRange();
        range.replace(Parameter.CARD_NUMBER, student.getId().toString(), false, true);
        range.replace(Parameter.ADMISSION_YEAR, student.getQuestionnaire().getAdmissionYear(), false, true);
        range.replace(Parameter.FIO, student.getLastName() + " " + student.getFirstName() + " " + student.getMiddleName(), false, true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        range.replace(Parameter.BIRTH_YEAR, sdf.format(student.getBirthDate()), false, true);
        range.replace(Parameter.BIRTH_PLACE, student.getQuestionnaire().getBirthPlace(), false, true);
//        range.replace(Parameter.RECRUIT_OFFICE, student.getQuestionnaire().getRecruitmentOffice(), false, true);
        range.replace(Parameter.FACULTY, student.getQuestionnaire().getFaculty(), false, true);
//        range.replace(Parameter.EDUCATION, student.getQuestionnaire().getEducation(), false, true);
//        range.replace(Parameter.RANK, student.getRank(), false, true);
        range.replace(Parameter.PARENT_ADDRESS, student.getQuestionnaire().getParentAddress().toString(), false, true);
        range.replace(Parameter.ADDRESS, student.getQuestionnaire().getAddress().toString(), false, true);
        return document;
    }
}
