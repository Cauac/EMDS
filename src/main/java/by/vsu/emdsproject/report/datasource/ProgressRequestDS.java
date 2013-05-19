package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.EMDSGlobal;
import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.model.comparator.StudentComparator;
import by.vsu.emdsproject.service.StudentService;
import by.vsu.emdsproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("progressRequestDataSource")
public class ProgressRequestDS extends AbstractReportDataSource {

    String title = "Сведения о успеваемости";

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String FACULTY_NAME = "facultyName";
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
        Teacher chief = teacherService.getChief();

        addParameter(ReportParameter.FACULTY, ReportUtil.getFullFacultyName(facultyName));
        addParameter(ReportParameter.FACULTY_IN_CASE, ReportUtil.getFacultyInCase(facultyName));
        addParameter(ReportParameter.DATE, EMDSGlobal.dateFormat.format(new Date()));

        if (chief != null) {
            addParameter(ReportParameter.CHIEF_FIO, ReportUtil.getReversShortFIO(chief));
            addParameter(ReportParameter.CHIEF_RANK, chief.getRank());
        }

        title += " " + facultyName;
    }

    @Override
    protected void initializeReportData(Map parameters) throws Exception {
        String facultyName = (String) parameters.get(DataSourceParameter.FACULTY_NAME);
        List<Student> students = studentService.getAbiturientsByFaculty(facultyName);
        Collections.sort(students, new StudentComparator());
        reportData = new ArrayList<HashMap>();
        for (int i = 0; i < students.size(); i++) {
            HashMap fields = new HashMap<String, String>();
            fields.put(Field.FIO, ReportUtil.getFullFIO(students.get(i)));
            fields.put(Field.NUMBER, i + 1);
            reportData.add(fields);
        }
    }
}
