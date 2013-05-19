package by.vsu.emdsproject.web.form;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.PersonCardDS;

import java.util.HashMap;
import java.util.Map;

public class PersonCardForm extends AbstractReportForm {

    private Group group;
    private Student student;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Map getReportDataMap() {
        Map map = new HashMap();
        map.put(PersonCardDS.DataSourceParameter.STUDENT, student);
        return map;
    }

    @Override
    public AbstractReportDataSource getReportDataSource() {
        return new PersonCardDS();
    }
}