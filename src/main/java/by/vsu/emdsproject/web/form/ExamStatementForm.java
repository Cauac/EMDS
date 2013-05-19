package by.vsu.emdsproject.web.form;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.ExamStatementDS;

import java.util.HashMap;
import java.util.Map;

public class ExamStatementForm extends AbstractReportForm {

    private Group group;
    private Teacher[] teachers;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    @Override
    public Map getReportDataMap() {
        Map map = new HashMap();
        map.put(ExamStatementDS.DataSourceParameter.GROUP, group);
        map.put(ExamStatementDS.DataSourceParameter.TEACHERS, teachers);
        return map;
    }

    @Override
    public AbstractReportDataSource getReportDataSource() {
        return (AbstractReportDataSource) EMDSContext.getInstance().getFactory().getBean("examStatementDataSource");
    }

}
