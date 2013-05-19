package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.report.aspose.report.AsposeReport;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReportFactory {

    /**
     * контекст построения отчетов aspose
     */
    protected static ApplicationContext asposeContext;

    static {
        asposeContext = new ClassPathXmlApplicationContext("spring/aspose-report-context.xml");
    }

    public static AsposeReport getReport(AbstractReportDataSource dataSource) {
        AsposeReport report = (AsposeReport) asposeContext.getBean(dataSource.getName());
        report.setDataSource(dataSource);
        return report;
    }

}
