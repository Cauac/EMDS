package by.vsu.emdsproject.report.aspose.report;

import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.ExamProtocolDS;
import com.aspose.words.Document;
import com.aspose.words.NodeType;
import com.aspose.words.Row;
import com.aspose.words.Table;

public class ExamProtocolReport extends AsposeReport {

    public ExamProtocolReport() {
    }

    @Override
    public Document generate() throws Exception {
        Document document = new Document(getTemplateFilePath(templateName));
        AbstractReportDataSource dataSource = getDataSource();

        replaceParametersInDocument(document);

        Table mainTable = (Table) document.getChild(NodeType.TABLE, 0, true);
        Row lastRow = mainTable.getLastRow();

        while (dataSource.next()) {
            mainTable.appendChild(lastRow.deepClone(true));

            Object number = dataSource.getFieldValue(ExamProtocolDS.Field.NUMBER);
            lastRow.getRange().replace(getPattern(ExamProtocolDS.Field.NUMBER), number.toString());
            Object fio = dataSource.getFieldValue(ExamProtocolDS.Field.SHORT_FIO);
            lastRow.getRange().replace(getPattern(ExamProtocolDS.Field.FIO), fio.toString());

            lastRow = mainTable.getLastRow();
        }
        mainTable.removeChild(lastRow);
        dataSource.toFirstRow();

        Table table = (Table) document.getChild(NodeType.TABLE, 1, true);
        lastRow = table.getLastRow();
        int size = dataSource.size();
        boolean isFullTable = size % 2 == 0;
        int rowCount = isFullTable ? size / 2 : size / 2 + 1;
        for (int i = 0; i < rowCount; i++) {
            table.appendChild(lastRow.deepClone(true));
            dataSource.next();
            Object number = dataSource.getFieldValue(ExamProtocolDS.Field.NUMBER);
            Object fio = dataSource.getFieldValue(ExamProtocolDS.Field.FIO);
            lastRow.getCells().get(0).getRange().replace(getPattern(ExamProtocolDS.Field.NUMBER), number.toString());
            lastRow.getCells().get(1).getRange().replace(getPattern(ExamProtocolDS.Field.FIO), fio.toString());
            lastRow = table.getLastRow();
        }

        table.removeChild(table.getLastRow());

        for (int i = rowCount; i < size; i++) {
            lastRow = table.getRows().get(1 + i - rowCount);
            dataSource.next();
            Object number = dataSource.getFieldValue(ExamProtocolDS.Field.NUMBER);
            Object fio = dataSource.getFieldValue(ExamProtocolDS.Field.FIO);
            lastRow.getCells().get(2).getRange().replace(getPattern(ExamProtocolDS.Field.NUMBER), number.toString());
            lastRow.getCells().get(3).getRange().replace(getPattern(ExamProtocolDS.Field.FIO), fio.toString());
        }
        if (!isFullTable) {
            table.getLastRow().getCells().get(2).getRange().replace(getPattern(ExamProtocolDS.Field.NUMBER), "" + size + 1);
            table.getLastRow().getCells().get(3).removeAllChildren();
        }

        return document;
    }
}
