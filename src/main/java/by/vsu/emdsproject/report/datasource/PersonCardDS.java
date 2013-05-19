package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.model.Student;

import java.util.Map;

public class PersonCardDS extends AbstractReportDataSource {

    String title = "Личная карточка";

    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String STUDENT = "student";
    }

    public static class ReportParameter extends AbstractReportDataSource.ReportParameter {

        public static final String ADMISSION_YEAR = "admissionYear";
        public static final String FIO = "fio";
        public static final String BIRTH_YEAR = "birthYear";
        public static final String BIRTH_PLACE = "birthPlace";
        public static final String RECRUIT_OFFICE = "recruitOffice";
        public static final String FACULTY = "faculty";
        public static final String EDUCATION = "education";
        public static final String DUTY = "duty";
        public static final String PARENT_ADDRESS = "parentAddress";
        public static final String ADDRESS = "address";
    }

    @Override
    public String getName() {
        return "personCard";
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    protected void initializeParameters(Map parameters) throws Exception {
        Student student = (Student) parameters.get(DataSourceParameter.STUDENT);
        title += " " + ReportUtil.getFullFIO(student);
        Questionnaire questionnaire = student.getQuestionnaire();
        addParameter(ReportParameter.FIO, ReportUtil.getFullFIO(student));
        addParameter(ReportParameter.ADMISSION_YEAR, questionnaire.getAdmissionYear());
        addParameter(ReportParameter.BIRTH_YEAR, ReportUtil.getYearInString(student.getBirthDate()));
        addParameter(ReportParameter.BIRTH_PLACE, questionnaire.getBirthPlace());
        addParameter(ReportParameter.RECRUIT_OFFICE, questionnaire.getRecruitmentOffice());
        addParameter(ReportParameter.FACULTY, questionnaire.getFaculty());
        addParameter(ReportParameter.EDUCATION, questionnaire.getEducationBefore());
        addParameter(ReportParameter.DUTY, questionnaire.getDuty());
        addParameter(ReportParameter.PARENT_ADDRESS, questionnaire.getParentAddress().toString());
        addParameter(ReportParameter.ADDRESS, questionnaire.getAddress().toString());
    }

    @Override
    protected void initializeReportData(Map parameters) throws Exception {
        return;
    }
}
