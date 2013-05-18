package by.vsu.emdsproject.web.form;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;

import java.util.Map;

public abstract class AbstractReportForm {

    public String getFormType() {
        return this.getClass().getSimpleName();
    }

    public abstract Map getReportDataMap();

    public abstract AbstractReportDataSource getReportDataSource();

}
