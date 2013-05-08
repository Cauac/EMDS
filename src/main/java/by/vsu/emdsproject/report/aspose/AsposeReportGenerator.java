package by.vsu.emdsproject.report.aspose;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.report.ReportGenerator;
import com.aspose.words.Document;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AsposeReportGenerator implements ReportGenerator {

    protected abstract String getContentType();

    protected abstract String getContentHeader();

    protected abstract String getContentDiscription();

    protected abstract int getSaveFormat();


    static {
        com.aspose.words.License wordsLicense = new com.aspose.words.License();
        try {
            wordsLicense.setLicense("/home/anton/Aspose.Total.Java.lic");
        } catch (Exception e) {
            Logger.getLogger(AsposeReportGenerator.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void exportReportInServlet(Document document, HttpServletResponse response) throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        document.save(stream, getSaveFormat());

        response.setContentLength(stream.size());
        response.setContentType(getContentType());
        response.setHeader(getContentDiscription(), getContentHeader());

        ServletOutputStream servletStream = response.getOutputStream();
        stream.writeTo(servletStream);
        servletStream.flush();
        servletStream.close();
    }

    @Override
    public void generatePersonCardReport(Student student, HttpServletResponse response) {
        PersonCardReport report = new PersonCardReport(student);
        try {
            exportReportInServlet(report.generate(), response);
        } catch (Exception e) {
            Logger.getLogger(AsposeReportGenerator.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void generateExamStatementReport(Group group, HttpServletResponse response) {
        ExamStatementReport report = new ExamStatementReport(group);
        try {
            exportReportInServlet(report.generate(), response);
        } catch (Exception e) {
            Logger.getLogger(AsposeReportGenerator.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
