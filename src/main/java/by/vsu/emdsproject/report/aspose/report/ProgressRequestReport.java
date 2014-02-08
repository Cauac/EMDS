package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.ExamStatementDS;
import com.aspose.words.Document;
import com.aspose.words.NodeType;
import com.aspose.words.Row;
import com.aspose.words.Table;

public class ProgressRequestReport extends AsposeReport {

    public ProgressRequestReport(AbstractReportDataSource dataSource) {
        super(dataSource);
        templateName = "ProgressRequest.docx";
    }

    @Override
    public Document generate() throws Exception {
        Document document = new Document(getTemplateFilePath(templateName));
        AbstractReportDataSource dataSource = getDataSource();

        replaceParametersInDocument(document);

        Table table = (Table) document.getChild(NodeType.TABLE, 1, true);
        Row lastRow = table.getLastRow();
        while (dataSource.next()) {
            table.appendChild(lastRow.deepClone(true));

            Object number = dataSource.getFieldValue(ExamStatementDS.Field.NUMBER);
            lastRow.getRange().replace(getPattern(ExamStatementDS.Field.NUMBER), number.toString());
            Object fio = dataSource.getFieldValue(ExamStatementDS.Field.FIO);
            lastRow.getRange().replace(getPattern(ExamStatementDS.Field.FIO), fio.toString());

            lastRow = table.getLastRow();
        }
        table.removeChild(lastRow);

        return document;
    }
}
