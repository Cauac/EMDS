package by.vsu.emdsproject.report.aspose.generator;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.exception.EMDSException;
import by.vsu.emdsproject.report.ReportGenerator;
import by.vsu.emdsproject.report.aspose.report.ReportFactory;
import by.vsu.emdsproject.report.aspose.report.AsposeReport;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import com.aspose.words.Document;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AsposeReportGenerator implements ReportGenerator {

    public static final String CONTENT_HEADER = "attachment; filename*=UTF-8''";
    public static final String CONTENT_DESCRIPTION = "Content-Disposition";
    public static final String LICENSE_PROPERTY_NAME = "reports.license";

    static {
        com.aspose.words.License wordsLicense = new com.aspose.words.License();
        try {
            wordsLicense.setLicense(EMDSContext.getInstance().getEnvironment().getProperty(LICENSE_PROPERTY_NAME));
        } catch (Exception e) {
            Logger.getLogger(AsposeReportGenerator.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public abstract void exportDocumentInServlet(Document document, HttpServletResponse response) throws Exception;

    protected void generateReport(AsposeReport report, HttpServletResponse response) {
        try {
            Document document=report.generate();
            String header = CONTENT_HEADER + urlEncode(report.getDataSource().getTitle()) + getFileType();
            response.setHeader(CONTENT_DESCRIPTION, header);
            exportDocumentInServlet(document, response);
        }catch (EMDSException e){
            throw e;
        } catch (Exception e) {
            Logger.getLogger(AsposeReportGenerator.class.getName()).log(Level.SEVERE, null, e);
            throw new EMDSException("Ошибка при построении очтета");
        }
    }

    @Override
    public void generate(AbstractReportDataSource dataSource, HttpServletResponse response) {
        generateReport(ReportFactory.getReport(dataSource), response);
    }

    private String urlEncode(String str) throws UnsupportedEncodingException {
        String result = URLEncoder.encode(str, "UTF-8");
        result = result.replace("+", "%20");
        return result;
    }

    protected abstract String getFileType();
}