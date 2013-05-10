package by.vsu.emdsproject.report.aspose;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.report.ReportGenerator;
import by.vsu.emdsproject.report.aspose.docx.ExamStatementReport;
import by.vsu.emdsproject.report.aspose.docx.PersonCardReport;
import com.aspose.words.Document;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AsposeReportGenerator implements ReportGenerator {

    protected abstract String getContentType();

    protected abstract String getContentHeader();

    protected abstract String getContentDescription();

    protected abstract int getSaveFormat();


    static {
        com.aspose.words.License wordsLicense = new com.aspose.words.License();
        try {
            ClassPathResource resource = new ClassPathResource("../lib/Aspose.Total.Java.lic");
            wordsLicense.setLicense(resource.getURL().getPath());
        } catch (Exception e) {
            Logger.getLogger(AsposeReportGenerator.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void exportDocumentInServlet(Document document, HttpServletResponse response) throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        document.save(stream, getSaveFormat());

        response.setContentLength(stream.size());
        response.setContentType(getContentType());
        response.setHeader(getContentDescription(), getContentHeader());

        ServletOutputStream servletStream = response.getOutputStream();
        stream.writeTo(servletStream);
        servletStream.flush();
        servletStream.close();
    }

    protected void generateReport(AsposeReport report, HttpServletResponse response) {
        try {
            exportDocumentInServlet(report.generate(), response);
        } catch (Exception e) {
            Logger.getLogger(AsposeReportGenerator.class.getName()).log(Level.SEVERE, null, e);
            //TODO обработать ошибку построения отчета
        }
    }

    @Override
    public void generatePersonCardReport(Student student, HttpServletResponse response) {
        generateReport(new PersonCardReport(student), response);
    }

    @Override
    public void generateExamStatementReport(Group group, HttpServletResponse response) {
        generateReport(new ExamStatementReport(group), response);
    }

}
