package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.comparator.StudentComparator;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExamStatementDS extends AbstractReportDataSource {

    String title = "Зачетно-экзаменационная ведомость";

    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String GROUP = "group";
        public static final String TEACHERS = "teachers";
        public static final String STUDENTS = "student";
        public static final String CHIEF = "chief";
    }

    public static class ReportParameter extends AbstractReportDataSource.ReportParameter {

        public static String GROUP_NAME = "groupName";
        public static String TEACHERS_FIO = "teacherFio";
        public static String CHIEF_FIO = "rchiefFio";
        public static String CHIEF_RANK = "chiefRank";
    }

    public static class Field extends AbstractReportDataSource.Field {

        public static String FIO = "fio";
        public static String NUMBER = "n";
    }

    @Override
    public String getName() {
        return "examStatement";
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    protected void initializeParameters(Map parameters) throws Exception {
        DBObject group = (DBObject) parameters.get(DataSourceParameter.GROUP);
        BasicDBList teachers = (BasicDBList) parameters.get(DataSourceParameter.TEACHERS);
        Object chief = parameters.get(DataSourceParameter.CHIEF);

        title += " " + group.get("_id");
        addParameter(ReportParameter.GROUP_NAME, group.get("_id"));

        String teachersFio = "";
        for (Object teacherObject : teachers) {
            teachersFio += ReportUtil.getFullFIO((DBObject) teacherObject) + ", ";
        }
        teachersFio = teachersFio.substring(0, teachersFio.length() - 2);
        addParameter(ReportParameter.TEACHERS_FIO, teachersFio);

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
            fields.put(Field.NUMBER, i + 1);
            reportData.add(fields);
        }
    }
}
