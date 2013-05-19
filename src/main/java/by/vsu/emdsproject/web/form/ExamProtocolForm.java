package by.vsu.emdsproject.web.form;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.ExamProtocolDS;

import java.util.HashMap;
import java.util.Map;

public class ExamProtocolForm extends AbstractReportForm {

    private Group group;
    private String[] members;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        this.members = members;
    }

    @Override
    public Map getReportDataMap() {
        Map map = new HashMap();
        map.put(ExamProtocolDS.DataSourceParameter.GROUP, group);
        map.put(ExamProtocolDS.DataSourceParameter.MEMBERS, members);
        return map;
    }

    @Override
    public AbstractReportDataSource getReportDataSource() {
        return new ExamProtocolDS();
    }

}
