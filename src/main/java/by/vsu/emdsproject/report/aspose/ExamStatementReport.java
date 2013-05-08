package by.vsu.emdsproject.report.aspose;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import com.aspose.words.*;

public class ExamStatementReport {

    private Group group;

    public static final String temlateName = "/home/anton/ExamStatement.docx";

    public ExamStatementReport(Group group) {
        this.group = group;
    }

    public Document generate() throws Exception {
        Document document = new Document(temlateName);
        document.getRange().replace("groupName", group.getTitle(), false, true);
        Table table = (Table) document.getChild(NodeType.TABLE, 0, true);
        Row lastRow = table.getLastRow();
        Integer number = 1;
        for (Student student : group.getStudents()) {
            Cell cell = lastRow.getCells().get(0);
            cell.getFirstParagraph().removeAllChildren();
            cell.getFirstParagraph().appendChild(new Run(document, number.toString()));

            String fio = student.getLastName() + " "
                    + student.getFirstName().charAt(0) + "."
                    + student.getMiddleName().charAt(0) + ".";
            cell = lastRow.getCells().get(1);
            cell.getFirstParagraph().removeAllChildren();
            cell.getFirstParagraph().appendChild(new Run(document, fio));

            number++;
            table.appendChild(lastRow.deepClone(true));
        }
        table.removeChild(lastRow);
        return document;
    }

}
