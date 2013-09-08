package by.vsu.emdsproject.report.aspose.report;

import com.aspose.words.*;

public class PersonCardReport extends AsposeReport {

    public PersonCardReport() {
    }

    @Override
    public Document generate() throws Exception {

        Document document = new Document(getTemplateFilePath(templateName));

        replaceParametersInDocument(document);

        return document;
    }
}
