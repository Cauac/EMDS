package by.vsu.emdsproject.report.aspose.generator;

import by.vsu.emdsproject.exception.EMDSException;
import by.vsu.emdsproject.report.ReportGenerator;
import by.vsu.emdsproject.report.aspose.report.ReportFactory;
import by.vsu.emdsproject.report.aspose.report.AsposeReport;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import com.aspose.words.Document;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AsposeReportGenerator implements ReportGenerator {

    static {
        com.aspose.words.License wordsLicense = new com.aspose.words.License();
        try {
            ClassPathResource resource = new ClassPathResource("../lib/Aspose.Total.Java.lic");
            wordsLicense.setLicense(resource.getURL().getPath());
        } catch (Exception e) {
            Logger.getLogger(AsposeReportGenerator.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public abstract void exportDocumentInServlet(Document document, HttpServletResponse response) throws Exception;

    protected void generateReport(AsposeReport report, HttpServletResponse response) {
        try {
            exportDocumentInServlet(report.generate(), response);
        } catch (Exception e) {
            Logger.getLogger(AsposeReportGenerator.class.getName()).log(Level.SEVERE, null, e);
            throw new EMDSException("Ошибка при построении очтета");
        }
    }

    @Override
    public void generate(AbstractReportDataSource dataSource, HttpServletResponse response) {
        generateReport(ReportFactory.getReport(dataSource), response);
    }
}