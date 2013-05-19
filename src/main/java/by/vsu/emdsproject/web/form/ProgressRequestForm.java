package by.vsu.emdsproject.web.form;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.ProgressRequestDS;

import java.util.HashMap;
import java.util.Map;

public class ProgressRequestForm extends AbstractReportForm {

    private String facultyName;

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public Map getReportDataMap() {
        Map map = new HashMap();
        map.put(ProgressRequestDS.DataSourceParameter.FACULTY_NAME, facultyName);
        return map;
    }

    @Override
    public AbstractReportDataSource getReportDataSource() {
        return (AbstractReportDataSource) EMDSContext.getInstance().getFactory().getBean("progressRequestDataSource");
    }
}
