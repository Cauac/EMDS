package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.AllowedListDS;
import com.aspose.words.*;

import java.util.regex.Pattern;

public class AllowedListReport extends AsposeReport {

    public static final String TEMPLATE_NAME = "AllowedList.docx";

    public static final Pattern LIST_START = Pattern.compile("<startList>");

    public AllowedListReport() {
    }

    @Override
    public Document generate() throws Exception {
        Document document = new Document(getTemplateFilePath(TEMPLATE_NAME));
        AbstractReportDataSource dataSource = getDataSource();

        replaceParametersInDocument(document);

        int nodeNumber = 0;
        Node startList = document.getChild(NodeType.PARAGRAPH, nodeNumber, true);
        while (startList != null) {
            if (startList.toTxt().contains(LIST_START.toString())) {
                break;
            }
            nodeNumber++;
            startList = document.getChild(NodeType.PARAGRAPH, nodeNumber, true);
        }

        DocumentBuilder builder = new DocumentBuilder(document);
        builder.moveTo(startList);
        startList.getRange().replace(LIST_START, "");

        while (dataSource.next()) {
            builder.writeln(dataSource.getFieldValue(AllowedListDS.Field.FIO).toString());
        }

        builder.getListFormat().removeNumbers();

        return document;
    }
}
