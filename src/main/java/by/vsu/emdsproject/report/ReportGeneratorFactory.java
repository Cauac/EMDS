package by.vsu.emdsproject.report;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReportGeneratorFactory {

    private static final String DOCX_REPORT_GENERATOR = "docxReportGenerator";
    private static final String PDF_REPORT_GENERATOR = "pdfReportGenerator";
    /*
     * контекст построения отчетов
     */
    protected static ApplicationContext reportContext;

    static{
        reportContext = new ClassPathXmlApplicationContext("report-factory.xml");
    }

    public static ReportGenerator getDocxReportGenerator() {
        return (ReportGenerator) reportContext.getBean(DOCX_REPORT_GENERATOR);
    }

    public static ReportGenerator getPdfReportGenerator() {
        return (ReportGenerator) reportContext.getBean(PDF_REPORT_GENERATOR);
    }
}
