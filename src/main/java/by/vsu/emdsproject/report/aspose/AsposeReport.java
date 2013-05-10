package by.vsu.emdsproject.report.aspose;

import com.aspose.words.Document;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public abstract class AsposeReport {

    public String getTemplateFilePath(String filename) {
        try {
            ClassPathResource resource = new ClassPathResource("../reports/" + filename);
            return resource.getURL().getPath();
        } catch (IOException e) {
           // TODO выбросить ошибку не найден шаблон отчета и корректно её обработать
        }
        return "";
    }

    public abstract Document generate() throws Exception;

}
