package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import org.springframework.beans.factory.BeanFactory;

public class ReportFactory {

    /**
     * контекст построения отчетов aspose
     */
    protected static BeanFactory factory= EMDSContext.getInstance().getFactory();

    public static AsposeReport getReport(AbstractReportDataSource dataSource) {
        AsposeReport report = (AsposeReport) factory.getBean(dataSource.getName());
        report.setDataSource(dataSource);
        return report;
    }

}
