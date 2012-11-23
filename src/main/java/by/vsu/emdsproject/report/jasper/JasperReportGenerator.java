package by.vsu.emdsproject.report.jasper;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.report.ReportGenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.FileBufferedOutputStream;

/**
 * Builder скрывающий механизм формирования отчетов технологии JasperReports
 */
public abstract class JasperReportGenerator implements ReportGenerator {

    /**
     * определяет в каком виде представить отчет
     *
     * @return экспортер отчета
     */
    protected abstract JRAbstractExporter getExporter();

    protected abstract String getContentType();

    protected abstract String getContentHeader();

    protected abstract String getContentDiscription();

    /**
     * заполнение отчета данными и передача его данных в поток
     *
     * @param dsWrapper данные для отчета
     * @return поток данных отчета
     * @throws IOException ошибка при использовании потоков
     * @throws JRException ошибка заполенния отчета данными
     */
    private FileBufferedOutputStream generateReportStream(JasperPrint jasperPrint) throws IOException, JRException {
        FileBufferedOutputStream outStream = new FileBufferedOutputStream();

        try {
            JRAbstractExporter exporter = this.getExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
            exporter.exportReport();
        } finally {
            outStream.close();
        }
        return outStream;
    }

    /**
     * формирование отчета и заполнение сервлета результатами
     *
     * @param dsWrapper данные для отчета
     * @param response
     * @throws IOException ошибка при использовании потоков
     * @throws JRException ошибка заполенния отчета данными
     */
    private void generateReportInServlet(JasperPrint jasperPrint, HttpServletResponse response) throws IOException, JRException {
        FileBufferedOutputStream dataStream = this.generateReportStream(jasperPrint);
        response.setContentLength(dataStream.size());
        response.setContentType(this.getContentType());
        response.setHeader(this.getContentDiscription(), getContentHeader());
        ServletOutputStream servletStream = response.getOutputStream();
        dataStream.writeData(servletStream);
        dataStream.dispose();
        servletStream.flush();
        servletStream.close();
    }

    /**
     * формирование отчета и заполнение файла результатами
     *
     * @param dsWrapper данные для отчета
     * @param file файл в который необходимо сохранить отчет
     * @throws IOException
     * @throws JRException
     */
    private void generateReportInFile(JasperPrint jasperPrint, File file) throws IOException, JRException {
        FileBufferedOutputStream dataStream = this.generateReportStream(jasperPrint);
        FileOutputStream fileStream = new FileOutputStream(file);
        dataStream.writeData(fileStream);
        dataStream.dispose();
        fileStream.flush();
        fileStream.close();
    }

    public void generatePersonCardReport(Student student, HttpServletResponse response) {
        try {
            PersonCardReportDSWrapper dsWrapper = new PersonCardReportDSWrapper(student);
            JasperPrint jasperPrint = JasperFillManager.fillReport(dsWrapper.getTemplateName(), dsWrapper.getDataSource(), new JREmptyDataSource());
            generateReportInServlet(jasperPrint, response);
        } catch (IOException ex) {
            Logger.getLogger(JasperReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(JasperReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
