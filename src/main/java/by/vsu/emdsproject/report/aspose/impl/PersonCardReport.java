package by.vsu.emdsproject.report.aspose.impl;

import by.vsu.emdsproject.report.aspose.AsposeReport;
import com.aspose.words.*;

public class PersonCardReport extends AsposeReport {

    public static final String TEMPLATE_NAME = "PersonCard.docx";

    public PersonCardReport() {
    }

    @Override
    public Document generate() throws Exception {

        Document document = new Document(getTemplateFilePath(TEMPLATE_NAME));

        replaceParametersInDocument(document);

        return document;
    }
}
