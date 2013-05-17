package by.vsu.emdsproject.web.form;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;

import java.util.Map;

public abstract class AbstractReportForm {

    public abstract Map getReportDataMap();

    public abstract AbstractReportDataSource getReportDataSource();

}
