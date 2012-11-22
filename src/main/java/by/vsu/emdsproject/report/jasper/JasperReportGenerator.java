package by.vsu.emdsproject.report.jasper;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.report.ReportGenerator;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.FileBufferedOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class JasperReportGenerator implements ReportGenerator {

    /**
     * заполняем отчет данными и выдаём в поток
     *
     * @param report Скомпилированный шаблон еще не заполненный данными
     * @param parameters Данные для заполнения в виде параметров
     * @throws JRException
     */
    private void generateReport(String templateName, HashMap parameters, HttpServletResponse response) throws JRException {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("/home/anton/r1.jasper", parameters, new JREmptyDataSource());
            JRDocxExporter ex = new JRDocxExporter();

            FileBufferedOutputStream fbos = new FileBufferedOutputStream();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            ex.setParameter(JRExporterParameter.OUTPUT_STREAM, fbos);

            ex.exportReport();
            fbos.close();

            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-Disposition", "inline; filename=\"file.docx\"");
            response.setContentLength(fbos.size());

            ServletOutputStream ouputStream = response.getOutputStream();

            fbos.writeData(ouputStream);
            fbos.dispose();
            ouputStream.flush();
            ouputStream.close();

            fbos.dispose();
        } catch (IOException ex1) {
            Logger.getLogger(JasperReportGenerator.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    /**
     * заполняем отчет данными и выдаём в поток
     *
     * @param report Скомпилированный шаблон еще не заполненный данными
     * @param parameters Данные для заполнения в виде параметров
     * @param dataSource Данные для заполнения в виде коллекции объектов
     * @throws JRException
     */
    private void generateReport(JasperReport report, HashMap parameters, JRBeanCollectionDataSource dataSource) throws JRException {
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);
        JRDocxExporter ex = new JRDocxExporter();
        ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        ex.exportReport();
    }

    public void generatePersonCardReport(Student student, HttpServletResponse response) {
        try {
            PersonCardDataSourseWrapper ds = new PersonCardDataSourseWrapper(student);
            generateReport(PersonCardDataSourseWrapper.templateName, ds.getDataSource(), response);
        } catch (JRException ex) {
            Logger.getLogger(JasperReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
