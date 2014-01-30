package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;

public class ReportFactory {

    public static AsposeReport getReport(AbstractReportDataSource dataSource) {
        switch (dataSource.getName()) {
            case "personCard":
                return new PersonCardReport(dataSource);
            case "allowedList":
                return new AllowedListReport(dataSource);
            case "examProtocol":
                return new ExamProtocolReport(dataSource);
            case "examStatement":
                return new ExamStatementReport(dataSource);
            case "progressRequest":
                return new ProgressRequestReport(dataSource);
        }
        return null;
    }
}
