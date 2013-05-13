package by.vsu.emdsproject.report.aspose.impl;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.report.aspose.AsposeReport;
import com.aspose.words.*;

import java.util.regex.Pattern;

public class AllowedListReport extends AsposeReport {

    public static final String TEMPLATE_NAME = "AllowedList.docx";
    public static final Pattern FIO = Pattern.compile("<startList>");
    public static Pattern GROUP_NAME = Pattern.compile("<groupName>");
    private Group group;

    public AllowedListReport(Group group) {
        this.group = group;
    }

    @Override
    public Document generate() throws Exception {
        Document document = new Document(getTemplateFilePath(TEMPLATE_NAME));
        document.getRange().replace(GROUP_NAME, group.getTitle());

        int nodeNumber = 0;
        Node startList = document.getChild(NodeType.PARAGRAPH, nodeNumber, true);
        while (startList != null) {
            if (startList.toTxt().contains(FIO.toString())) {
                break;
            }
            nodeNumber++;
            startList = document.getChild(NodeType.PARAGRAPH, nodeNumber, true);
        }

        DocumentBuilder builder = new DocumentBuilder(document);
        builder.moveTo(startList);
        startList.getRange().replace(FIO, "");
        for (Student student : group.getStudents()) {
            String fio = student.getLastName() + " "
                    + student.getFirstName() + " "
                    + student.getMiddleName();
            builder.writeln(fio);
        }
        builder.getListFormat().removeNumbers();

        return document;
    }
}
