package by.vsu.emdsproject.report.jasper;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.report.ReportGenerator;
import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

public class JasperReportGenerator implements ReportGenerator {

    /**
     * заполняем отчет данными и выдаём в поток
     *
     * @param report Скомпилированный шаблон еще не заполненный данными
     * @param parameters Данные для заполнения в виде параметров
     * @throws JRException
     */
    private void generateReport(JasperReport report, HashMap parameters) throws JRException {
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters);
        JRDocxExporter ex = new JRDocxExporter();
        ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        ex.exportReport();
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

    public void generatePersonCardReport(Student student) {
        try {
            HashMap map=new HashMap();
            JasperReportTemlate t = ReportTemplateFactory
                    .getReportTemplate(ReportTemplateFactory.ReportName.PERSON_CARD_REPORT);
            JasperReport jasperReport = JasperCompileManager
                    .compileReport(t.getTemplateFileName());
            generateReport(jasperReport, map);
        } catch (JRException ex) {
            Logger.getLogger(JasperReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
