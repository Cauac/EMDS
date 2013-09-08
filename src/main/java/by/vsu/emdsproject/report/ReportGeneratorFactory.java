package by.vsu.emdsproject.report;

import by.vsu.emdsproject.common.EMDSContext;
import org.springframework.beans.factory.BeanFactory;

public class ReportGeneratorFactory {

    private static final String DOCX_REPORT_GENERATOR = "docxReportGenerator";
    private static final String PDF_REPORT_GENERATOR = "pdfReportGenerator";
    /*
     * контекст построения отчетов
     */
    protected static BeanFactory factory= EMDSContext.getInstance().getFactory();

    public static ReportGenerator getDocxReportGenerator() {
        return (ReportGenerator) factory.getBean(DOCX_REPORT_GENERATOR);
    }

    public static ReportGenerator getPdfReportGenerator() {
        return (ReportGenerator) factory.getBean(PDF_REPORT_GENERATOR);
    }
}
