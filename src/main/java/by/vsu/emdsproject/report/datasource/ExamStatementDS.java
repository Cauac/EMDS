package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.model.comparator.StudentComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component("examStatementDataSource")
public class ExamStatementDS extends AbstractReportDataSource {

    String title = "Зачетно-экзаменационная ведомость";

    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String GROUP = "group";
        public static final String TEACHERS = "teachers";
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
        Group group = (Group) parameters.get(DataSourceParameter.GROUP);
        Teacher[] teachers = (Teacher[]) parameters.get(DataSourceParameter.TEACHERS);
//        Teacher chief = teacherService.getChief();

        title += " " + group.getTitle();
        addParameter(ReportParameter.GROUP_NAME, group.getTitle());

        String teachersFio = "";
        for (Teacher t : teachers) {
            teachersFio += ReportUtil.getFullFIO(t) + ", ";
        }
        teachersFio = teachersFio.substring(0, teachersFio.length() - 2);
        addParameter(ReportParameter.TEACHERS_FIO, teachersFio);

//        if (chief != null) {
//            addParameter(ReportParameter.CHIEF_FIO, ReportUtil.getReversShortFIO(chief));
//            addParameter(ReportParameter.CHIEF_RANK, chief.getRank());
//        }
    }

    @Override
    protected void initializeReportData(Map parameters) throws Exception {
        Group group = (Group) parameters.get(DataSourceParameter.GROUP);
        reportData = new ArrayList<HashMap>();

        ArrayList<Student> students = new ArrayList<Student>(group.getStudents());
        Collections.sort(students, new StudentComparator());

        for (int i = 0; i < students.size(); i++) {
            HashMap fields = new HashMap<String, String>();
            fields.put(Field.FIO, ReportUtil.getShortFIO(students.get(i)));
            fields.put(Field.NUMBER, i + 1);
            reportData.add(fields);
        }
    }
}
