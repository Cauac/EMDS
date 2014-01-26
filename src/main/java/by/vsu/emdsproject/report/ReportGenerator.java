package by.vsu.emdsproject.report;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;

import javax.servlet.http.HttpServletResponse;

public interface ReportGenerator {

    public String generate(AbstractReportDataSource datasource, HttpServletResponse response);
}
