package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.exception.EMDSException;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import com.aspose.words.Document;
import com.aspose.words.Range;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public abstract class AsposeReport {

    private AbstractReportDataSource ds;

    public String getTemplateFilePath(String filename) {
        try {
            ClassPathResource resource = new ClassPathResource("../reports/" + filename);
            return resource.getURL().getPath();
        } catch (IOException e) {
            throw new EMDSException("Не найден шаблон отчета " + filename + ". Проверте папку с шаблонами отчетов.");
        }
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

    public abstract Document generate() throws Exception;

}
