package by.vsu.emdsproject.report.jasper;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

/**
 * класс формирующий отчеты в формате docx
 */
public class JasperReportDocxGenerator extends JasperReportGenerator {

    public static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String CONTENT_HEADER = "inline; filename=\"file.docx\"";
    public static final String CONTENT_DISCRIPTION = "Content-Disposition";

    @Override
    protected JRAbstractExporter getExporter() {
        return new JRDocxExporter();
    }

    @Override
    protected String getContentType() {
        return CONTENT_TYPE;
    }

    @Override
    protected String getContentHeader() {
        return CONTENT_HEADER;
    }

    @Override
    protected String getContentDiscription() {
        return CONTENT_DISCRIPTION;
    }
}
