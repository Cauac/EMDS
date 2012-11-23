package by.vsu.emdsproject.report.jasper;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class JasperReportPdfGenerator extends JasperReportGenerator {

    @Override
    protected JRAbstractExporter getExporter() {
        return new JRPdfExporter();
    }

    @Override
    protected String getContentType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String getContentHeader() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String getContentDiscription() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
