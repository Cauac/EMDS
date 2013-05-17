package by.vsu.emdsproject.report.aspose.impl;

import by.vsu.emdsproject.report.aspose.AsposeReport;
import com.aspose.words.*;

import java.util.HashMap;
import java.util.regex.Pattern;

public class PersonCardReport extends AsposeReport {

    public static final String TEMPLATE_NAME = "PersonCard.docx";

    public PersonCardReport() {
    }

    @Override
    public Document generate() throws Exception {

        Document document = new Document(getTemplateFilePath(TEMPLATE_NAME));

        Range range = document.getRange();
        HashMap<String, String> params = getDataSource().getParameters();
        for (String paramName : params.keySet()) {
            Pattern pattern = getPattern(paramName);
            range.replace(pattern, params.get(paramName));
        }

        return document;
    }
}
