package by.vsu.emdsproject.report.aspose;

import com.aspose.words.Document;

public abstract class AsposeReport {

    public String getTemplateFilePath(String filename) {
//        try {
            /*ClassPathResource resource = new ClassPathResource("../reports/" + filename);
            return resource.getURL().getPath();*/
        return "c:/templates/" + filename;
//        } catch (IOException e) {
//           TODO выбросить ошибку не найден шаблон отчета и корректно её обработать
//        }
//        return "";
    }

    public abstract Document generate() throws Exception;

}
