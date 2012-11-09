package by.vsu.emdsproject.report.jasper;

import by.vsu.emdsproject.report.IReport;
import by.vsu.emdsproject.report.ReportGenerator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

public class JasperReportGenerator implements ReportGenerator {

    public void createReport(IReport report) {
        try {
            JasperReport jasperReport = JasperCompileManager
                    .compileReport(report.getTemplateFileName());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(report.getDataSource());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                    report.getParametrs(), dataSource);
            JRDocxExporter ex = new JRDocxExporter();
            ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            ex.exportReport();
        } catch (JRException ex1) {
//            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
}
