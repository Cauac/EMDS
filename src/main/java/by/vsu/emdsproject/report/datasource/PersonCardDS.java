package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.ReportUtil;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersonCardDS extends AbstractReportDataSource {

    String title = "Личная карточка";

    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String STUDENT = "student";
        public static final String PHOTO_DATA = "photoData";
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
        public static final String WITH_PHOTO = "withPhoto";
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
        DBObject student = (DBObject) parameters.get(DataSourceParameter.STUDENT);
        title += " " + ReportUtil.getFullFIO(student);
        DBObject q = (DBObject) student.get("questionnaire");
        addParameter(ReportParameter.FIO, ReportUtil.getFullFIO(student));
        addParameter(ReportParameter.ADMISSION_YEAR, q.get("admissionYear"));
        addParameter(ReportParameter.BIRTH_YEAR, ReportUtil.getYearFromDate(q, "birthDate"));
        addParameter(ReportParameter.BIRTH_PLACE, q.get("birthPlace"));
        addParameter(ReportParameter.RECRUIT_OFFICE, q.get("recruitmentOffice"));
        addParameter(ReportParameter.FACULTY, q.get("faculty"));
        addParameter(ReportParameter.EDUCATION, q.get("educationBefore"));
        addParameter(ReportParameter.DUTY, q.get("duty"));
        addParameter(ReportParameter.PARENT_ADDRESS, ReportUtil.printAddress(q.get("parentAddress")));
        addParameter(ReportParameter.ADDRESS, ReportUtil.printAddress(q.get("address")));
    }

    @Override
    protected void initializeReportData(Map parameters) throws Exception {
        if (!Boolean.parseBoolean(parameters.get(ReportParameter.WITH_PHOTO).toString())) {
            return;
        }
        DBObject student = (DBObject) parameters.get(DataSourceParameter.STUDENT);
        HashMap fields = new HashMap();
        fields.put(DataSourceParameter.PHOTO_DATA, student.get("photo"));
        reportData = new ArrayList();
        reportData.add(fields);
    }
}
