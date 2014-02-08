package by.vsu.emdsproject.report.datasource;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.comparator.StudentComparator;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExamProtocolDS extends AbstractReportDataSource {

    String title = "Протокол экзаменационной комиссии";

    public static class DataSourceParameter extends AbstractReportDataSource.DataSourceParameter {

        public static final String GROUP = "group";
        public static final String SPECIALTY = "specialty";
        public static final String STUDENTS = "students";
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
        DBObject group = (DBObject) parameters.get(DataSourceParameter.GROUP);
        DBObject specialty = (DBObject) parameters.get(DataSourceParameter.SPECIALTY);
        DBObject members = (DBObject) parameters.get(DataSourceParameter.MEMBERS);

        if (members.containsField("member1")) {
            DBObject member = (DBObject) members.get("member1");
            addParameter(ReportParameter.MEMBER1_FIO, ReportUtil.getShortFIO(member));
            addParameter(ReportParameter.REVERS_MEMBER1_FIO, ReportUtil.getReversShortFIO(member));
            addParameter(ReportParameter.MEMBER1_RANK, ReportUtil.getString(member, "rank"));
        }
        if (members.containsField("member2")) {
            DBObject member = (DBObject) members.get("member2");
            addParameter(ReportParameter.MEMBER2_FIO, ReportUtil.getShortFIO(member));
            addParameter(ReportParameter.REVERS_MEMBER2_FIO, ReportUtil.getReversShortFIO(member));
            addParameter(ReportParameter.MEMBER2_RANK, ReportUtil.getString(member, "rank"));
        }
        if (members.containsField("member3")) {
            DBObject member = (DBObject) members.get("member3");
            addParameter(ReportParameter.MEMBER3_FIO, ReportUtil.getShortFIO(member));
            addParameter(ReportParameter.REVERS_MEMBER3_FIO, ReportUtil.getReversShortFIO(member));
            addParameter(ReportParameter.MEMBER3_RANK, ReportUtil.getString(member, "rank"));
        }
        if (members.containsField("member4")) {
            DBObject member = (DBObject) members.get("member4");
            addParameter(ReportParameter.MEMBER4_FIO, ReportUtil.getShortFIO(member));
            addParameter(ReportParameter.REVERS_MEMBER4_FIO, ReportUtil.getReversShortFIO(member));
            addParameter(ReportParameter.MEMBER4_RANK, ReportUtil.getString(member, "rank"));
        }

        title += " " + group.get("_id");
        addParameter(ReportParameter.GROUP_NAME, group.get("_id"));
        addParameter(ReportParameter.VUS, specialty.get("_id"));
        addParameter(ReportParameter.PROFILE, specialty.get("description"));
    }

    @Override
    protected void initializeReportData(Map parameters) throws Exception {
        BasicDBList students = (BasicDBList) parameters.get(DataSourceParameter.STUDENTS);
        reportData = new ArrayList();

        Collections.sort(students, new StudentComparator());

        for (int i = 0; i < students.size(); i++) {
            HashMap fields = new HashMap<String, String>();
            fields.put(Field.SHORT_FIO, ReportUtil.getShortFIO((DBObject) students.get(i)));
            fields.put(Field.FIO, ReportUtil.getFullFIO((DBObject) students.get(i)));
            fields.put(Field.NUMBER, i + 1);
            reportData.add(fields);
        }
    }
}
