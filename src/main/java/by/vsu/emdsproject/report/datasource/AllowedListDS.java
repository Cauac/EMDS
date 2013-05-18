package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component("allowedListDataSource")
public class AllowedListDS extends AbstractReportDataSource {

    @Autowired
    private TeacherService teacherService;

    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String GROUP = "group";
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
        return "Список допущенных";
    }

    @Override
    protected void initializeParameters(Map parameters) throws Exception {
        Group group = (Group) parameters.get(DataSourceParameter.GROUP);
        Teacher chief = teacherService.getChief();

        addParameter(ReportParameter.GROUP_NAME, group.getTitle());
        addParameter(ReportParameter.VUS, group.getSpecialty().getNumber());
        addParameter(ReportParameter.PROFILE, group.getSpecialty().getDescription());

        if (!group.getStudents().isEmpty()) {
            String faculty = group.getStudents().iterator().next().getQuestionnaire().getFaculty();
            addParameter(ReportParameter.FACULTY, ReportUtil.getFacultyInCase(faculty));
        }

        if (chief != null) {
            addParameter(ReportParameter.CHIEF_FIO, ReportUtil.getReversShortFIO(chief));
            addParameter(ReportParameter.CHIEF_RANK, chief.getRank());
        }

    }

    @Override
    protected void initializeReportData(Map parameters) throws Exception {
        Group group = (Group) parameters.get(DataSourceParameter.GROUP);
        reportData = new ArrayList<HashMap>();

        for (Student student : group.getStudents()) {
            HashMap fields = new HashMap<String, String>();
            fields.put(Field.FIO, ReportUtil.getFullFIO(student));
            reportData.add(fields);
        }
    }
}
