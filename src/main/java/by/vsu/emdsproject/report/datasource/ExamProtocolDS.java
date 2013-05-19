package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.comparator.StudentComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExamProtocolDS extends AbstractReportDataSource {

    String title = "Протокол экзаменационной комиссии";

    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String GROUP = "group";
        public static final String MEMBERS = "members";
    }

    public static class ReportParameter extends AbstractReportDataSource.ReportParameter {

        public static String GROUP_NAME = "groupName";
        public static String VUS = "vus";
        public static String PROFILE = "profile";
        public static String MEMBER1_RANK = "member1Rank";
        public static String MEMBER2_RANK = "member2Rank";
        public static String MEMBER3_RANK = "member3Rank";
        public static String MEMBER4_RANK = "member4Rank";
        public static String MEMBER1_FIO = "member1Fio";
        public static String MEMBER2_FIO = "member2Fio";
        public static String MEMBER3_FIO = "member3Fio";
        public static String MEMBER4_FIO = "member4Fio";
        public static String REVERS_MEMBER1_FIO = "rmember1Fio";
        public static String REVERS_MEMBER2_FIO = "rmember2Fio";
        public static String REVERS_MEMBER3_FIO = "rmember3Fio";
        public static String REVERS_MEMBER4_FIO = "rmember4Fio";
    }

    public static class Field extends AbstractReportDataSource.Field {

        public static String FIO = "fio";
        public static String SHORT_FIO = "shortFio";
        public static String NUMBER = "n";
    }

    @Override
    public String getName() {
        return "examProtocol";
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    protected void initializeParameters(Map parameters) throws Exception {
        Group group = (Group) parameters.get(DataSourceParameter.GROUP);
        String[] members = (String[]) parameters.get(DataSourceParameter.MEMBERS);

        String[] membersRank = new String[members.length];
        String[] membersFio = new String[members.length];
        String[] membersReversFio = new String[members.length];
        for (int i = 0; i < members.length; i++) {
            String[] split = members[i].split(" ");
            membersFio[i] = split[1] + " " + split[2];
            membersReversFio[i] = split[2] + " " + split[1];
            membersRank[i] = split[0];

        }
        title += " " + group.getTitle();
        addParameter(ReportParameter.GROUP_NAME, group.getTitle());
        addParameter(ReportParameter.VUS, group.getSpecialty().getNumber());
        addParameter(ReportParameter.PROFILE, group.getSpecialty().getDescription());
        addParameter(ReportParameter.MEMBER1_FIO, membersFio[0]);
        addParameter(ReportParameter.MEMBER2_FIO, membersFio[1]);
        addParameter(ReportParameter.MEMBER3_FIO, membersFio[2]);
        addParameter(ReportParameter.MEMBER4_FIO, membersFio[3]);
        addParameter(ReportParameter.REVERS_MEMBER1_FIO, membersReversFio[0]);
        addParameter(ReportParameter.REVERS_MEMBER2_FIO, membersReversFio[1]);
        addParameter(ReportParameter.REVERS_MEMBER3_FIO, membersReversFio[2]);
        addParameter(ReportParameter.REVERS_MEMBER4_FIO, membersReversFio[3]);
        addParameter(ReportParameter.MEMBER1_RANK, membersRank[0]);
        addParameter(ReportParameter.MEMBER2_RANK, membersRank[1]);
        addParameter(ReportParameter.MEMBER3_RANK, membersRank[2]);
        addParameter(ReportParameter.MEMBER4_RANK, membersRank[3]);
    }

    @Override
    protected void initializeReportData(Map parameters) throws Exception {
        Group group = (Group) parameters.get(DataSourceParameter.GROUP);
        reportData = new ArrayList<HashMap>();

        ArrayList<Student> students = new ArrayList<Student>(group.getStudents());
        Collections.sort(students, new StudentComparator());

        for (int i = 0; i < students.size(); i++) {
            HashMap fields = new HashMap<String, String>();
            fields.put(Field.SHORT_FIO, ReportUtil.getShortFIO(students.get(i)));
            fields.put(Field.FIO, ReportUtil.getFullFIO(students.get(i)));
            fields.put(Field.NUMBER, i + 1);
            reportData.add(fields);
        }
    }
}
