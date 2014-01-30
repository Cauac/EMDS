package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.exception.EMDSException;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import com.aspose.words.Document;
import com.aspose.words.Range;

import java.io.File;
import java.util.HashMap;
import java.util.regex.Pattern;

public abstract class AsposeReport {

    private AbstractReportDataSource ds;
    protected String templateName;
    public final static String REPORT_FOLDER_PROPERTY_NAME = "reports.templates.path";

    protected AsposeReport() {
    }

    protected AsposeReport(AbstractReportDataSource ds) {
        this.ds = ds;
    }

    public String getTemplateFilePath(String filename) {
        String reportFolder = EMDSContext.getInstance().getEnvironment().getProperty(REPORT_FOLDER_PROPERTY_NAME);
        File file = new File(reportFolder + filename);
        if (!file.exists()) {
            throw new EMDSException("Не найден шаблон отчета " + filename + ". Проверте папку с шаблонами отчетов.");
        }
        return reportFolder + filename;
    }

    protected void replaceParametersInDocument(Document document) throws Exception {
        Range range = document.getRange();
        HashMap<String, String> params = getDataSource().getParameters();
        for (String paramName : params.keySet()) {
            Pattern pattern = getPattern(paramName);
            range.replace(pattern, params.get(paramName));
        }
    }

    public Pattern getPattern(String parameterName) {
        return Pattern.compile("<" + parameterName + ">");
    }

    public AbstractReportDataSource getDataSource() {
        return ds;
    }

    public void setDataSource(AbstractReportDataSource ds) {
        this.ds = ds;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public abstract Document generate() throws Exception;

}
