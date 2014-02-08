package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.comparator.StudentComparator;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AllowedListDS extends AbstractReportDataSource {

    String title = "Список допущенных";


    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String GROUP = "group";
        public static final String SPECIALTY = "specialty";
        public static final String STUDENTS = "students";
        public static final String CHIEF = "chief";
    }

    public static class ReportParameter extends AbstractReportDataSource.ReportParameter {

        public static String GROUP_NAME = "groupName";
        public static String VUS = "vus";
        public static String PROFILE = "profile";
        public static String CHIEF_FIO = "chiefFio";
        public static String CHIEF_RANK = "chiefRank";
        public static String FACULTY = "faculty";
    }

    public static class Field extends AbstractReportDataSource.Field {

        public static String FIO = "fio";
    }

    @Override
    public String getName() {
        return "allowedList";
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    protected void initializeParameters(Map parameters) throws Exception {
        DBObject group = (DBObject) parameters.get(DataSourceParameter.GROUP);
        DBObject specialty = (DBObject) parameters.get(DataSourceParameter.SPECIALTY);
        BasicDBList students = (BasicDBList) parameters.get(DataSourceParameter.STUDENTS);
        Object chief = parameters.get(DataSourceParameter.CHIEF);

        title += " " + group.get("_id");
        addParameter(ReportParameter.GROUP_NAME, group.get("_id"));
        addParameter(ReportParameter.VUS, specialty.get("_id"));
        addParameter(ReportParameter.PROFILE, specialty.get("description"));

        if (!students.isEmpty()) {
            String faculty = ((DBObject) students.get(0)).get("faculty").toString();
            addParameter(ReportParameter.FACULTY, ReportUtil.getFacultyInCase(faculty));
        }

        if (chief != null) {
            DBObject c = (DBObject) chief;
            addParameter(ReportParameter.CHIEF_FIO, ReportUtil.getReversShortFIO(c));
            addParameter(ReportParameter.CHIEF_RANK, c.get("rank"));
        } else {
            addParameter(ReportParameter.CHIEF_FIO, "Начальник кафедры не назначен");
            addParameter(ReportParameter.CHIEF_RANK, "");
        }
    }

    @Override
    protected void initializeReportData(Map parameters) throws Exception {
        BasicDBList students = (BasicDBList) parameters.get(DataSourceParameter.STUDENTS);
        reportData = new ArrayList();

        Collections.sort(students, new StudentComparator());

        for (int i = 0; i < students.size(); i++) {
            HashMap fields = new HashMap<String, String>();
            fields.put(Field.FIO, ReportUtil.getShortFIO((DBObject) students.get(i)));
            reportData.add(fields);
        }
    }
}
