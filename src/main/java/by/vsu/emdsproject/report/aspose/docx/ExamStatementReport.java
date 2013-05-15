package by.vsu.emdsproject.report.aspose.docx;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.report.StudentComparator;
import by.vsu.emdsproject.report.aspose.AsposeReport;
import com.aspose.words.Document;
import com.aspose.words.NodeType;
import com.aspose.words.Row;
import com.aspose.words.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class ExamStatementReport extends AsposeReport {

    private Group group;
    private Teacher chief;

    public static final String TEMPLATE_NAME = "ExamStatement.docx";

    public static Pattern GROUP_NAME = Pattern.compile("<groupName>");
    public static Pattern NUMBER = Pattern.compile("<n>");
    public static Pattern FIO = Pattern.compile("<fio>");
    public static Pattern CHIEF = Pattern.compile("<chief>");

    public ExamStatementReport(Group group, Teacher chief) {
        this.group = group;
        this.chief = chief;
    }

    @Override
    public Document generate() throws Exception {

        Document document = new Document(getTemplateFilePath(TEMPLATE_NAME));

        document.getRange().replace(GROUP_NAME, group.getTitle());
        document.getRange().replace(CHIEF, chief.getLastName());
        Table table = (Table) document.getChild(NodeType.TABLE, 0, true);
        Row lastRow = table.getLastRow();
        Integer number = 1;
        ArrayList<Student> students = new ArrayList<Student>(group.getStudents());
        Collections.sort(students, new StudentComparator());
        for (Student student : students) {
            table.appendChild(lastRow.deepClone(true));
            String fio = student.getLastName() + " "
                    + student.getFirstName().charAt(0) + "."
                    + student.getMiddleName().charAt(0) + ".";
            lastRow.getRange().replace(NUMBER, number.toString());
            lastRow.getRange().replace(FIO, fio);
            number++;
            lastRow = table.getLastRow();
        }
        table.removeChild(lastRow);

        return document;
    }

}
