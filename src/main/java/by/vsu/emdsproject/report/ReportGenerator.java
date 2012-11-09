package by.vsu.emdsproject.report;

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
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReportGenerator {

    static class ReportName {

        public static final String PERSON_CARD_REPORT = "personCardRepost";
    }

    public void createReport(String reportName) {
        try {

            ApplicationContext context =
                    new ClassPathXmlApplicationContext("emds-model-context.xml");
            BeanFactory factory = (BeanFactory) context;
            IReport report = (IReport) factory.getBean(reportName);
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
