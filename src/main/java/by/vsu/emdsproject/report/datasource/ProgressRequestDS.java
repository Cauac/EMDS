package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.EMDSGlobal;
import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.comparator.StudentComparator;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

import java.util.*;

public class ProgressRequestDS extends AbstractReportDataSource {

    String title = "Сведения о успеваемости";

    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String FACULTY_NAME = "facultyName";
        public static final String CHIEF = "chief";
        public static final String STUDENTS = "students";
    }

    public static class ReportParameter extends AbstractReportDataSource.ReportParameter {

        public static String FACULTY = "faculty";
        public static String DATE = "date";
        public static String CHIEF_RANK = "chiefRank";
        public static String CHIEF_FIO = "chiefFio";
        public static String FACULTY_IN_CASE = "facultyInCase";
    }

    public static class Field extends AbstractReportDataSource.Field {

        public static String FIO = "fio";
        public static String NUMBER = "n";
    }

    @Override
    public String getName() {
        return "progressRequest";
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    protected void initializeParameters(Map parameters) throws Exception {
        String facultyName = (String) parameters.get(DataSourceParameter.FACULTY_NAME);
        Object chief = parameters.get(DataSourceParameter.CHIEF);

        addParameter(ReportParameter.FACULTY, ReportUtil.getFullFacultyName(facultyName));
        addParameter(ReportParameter.FACULTY_IN_CASE, ReportUtil.getFacultyInCase(facultyName));
        addParameter(ReportParameter.DATE, EMDSGlobal.dateFormat.format(new Date()));

        if (chief != null) {
            DBObject c = (DBObject) chief;
            addParameter(ReportParameter.CHIEF_FIO, ReportUtil.getReversShortFIO(c));
            addParameter(ReportParameter.CHIEF_RANK, c.get("rank"));
        } else {
            addParameter(ReportParameter.CHIEF_FIO, "Начальник кафедры не назначен");
            addParameter(ReportParameter.CHIEF_RANK, "");
        }

        title += " " + facultyName;
    }

    @Override
    protected void initializeReportData(Map parameters) throws Exception {
        BasicDBList students = (BasicDBList) parameters.get(DataSourceParameter.STUDENTS);
        reportData = new ArrayList();

        Collections.sort(students, new StudentComparator());

        for (int i = 0; i < students.size(); i++) {
            HashMap fields = new HashMap<String, String>();
            fields.put(Field.FIO, ReportUtil.getShortFIO((DBObject) students.get(i)));
            fields.put(Field.NUMBER, i + 1);
            reportData.add(fields);
        }
    }
}
