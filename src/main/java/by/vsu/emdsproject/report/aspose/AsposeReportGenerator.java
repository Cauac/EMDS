package by.vsu.emdsproject.report.aspose;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.report.ReportGenerator;
import by.vsu.emdsproject.report.aspose.impl.AllowedListReport;
import by.vsu.emdsproject.report.aspose.impl.ExamProtocolReport;
import by.vsu.emdsproject.report.aspose.impl.ExamStatementReport;
import by.vsu.emdsproject.report.aspose.impl.PersonCardReport;
import com.aspose.words.Document;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AsposeReportGenerator implements ReportGenerator {

    static {
        com.aspose.words.License wordsLicense = new com.aspose.words.License();
        try {
//            ClassPathResource resource = new ClassPathResource("../lib/Aspose.Total.Java.lic");
//            wordsLicense.setLicense(resource.getURL().getPath());
            wordsLicense.setLicense("c:/templates/Aspose.Total.Java.lic");
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
            //TODO обработать ошибку построения отчета
        }
    }

    @Override
    public void generatePersonCardReport(Student student, HttpServletResponse response) {
        generateReport(new PersonCardReport(student), response);
    }

    @Override
    public void generateExamStatementReport(Group group, Teacher chief, HttpServletResponse response) {
        generateReport(new ExamStatementReport(group, chief), response);
    }

    @Override
    public void generateExamProtocolReport(Group group, String[] members, HttpServletResponse response) {
        generateReport(new ExamProtocolReport(group, members), response);
    }

    @Override
    public void generateAllowedListReport(Group group, HttpServletResponse response) {
        generateReport(new AllowedListReport(group), response);
    }
}