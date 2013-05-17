package by.vsu.emdsproject.report.aspose;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import com.aspose.words.Document;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.regex.Pattern;

public abstract class AsposeReport {

    private AbstractReportDataSource ds;

    public String getTemplateFilePath(String filename) {
        try {
            ClassPathResource resource = new ClassPathResource("../reports/" + filename);
            return resource.getURL().getPath();
        } catch (IOException e) {
//           TODO выбросить ошибку не найден шаблон отчета и корректно её обработать
        }
        return "";
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
