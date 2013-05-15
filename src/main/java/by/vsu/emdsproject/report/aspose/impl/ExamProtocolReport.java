package by.vsu.emdsproject.report.aspose.impl;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.report.StudentComparator;
import by.vsu.emdsproject.report.aspose.AsposeReport;
import com.aspose.words.Document;
import com.aspose.words.NodeType;
import com.aspose.words.Row;
import com.aspose.words.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class ExamProtocolReport extends AsposeReport {

    public static final String TEMPLATE_NAME = "ExamProtocol.docx";
    private Group group;
    private String[] members;
    private String[] rmembers;

    public static Pattern GROUP_NAME = Pattern.compile("<groupName>");
    public static Pattern NUMBER = Pattern.compile("<n>");
    public static Pattern FIO = Pattern.compile("<fio>");
    public static Pattern MEMBER1 = Pattern.compile("<member1>");
    public static Pattern MEMBER2 = Pattern.compile("<member2>");
    public static Pattern MEMBER3 = Pattern.compile("<member3>");
    public static Pattern MEMBER4 = Pattern.compile("<member4>");
    public static Pattern REVERS_MEMBER1 = Pattern.compile("<rmember1>");
    public static Pattern REVERS_MEMBER2 = Pattern.compile("<rmember2>");
    public static Pattern REVERS_MEMBER3 = Pattern.compile("<rmember3>");
    public static Pattern REVERS_MEMBER4 = Pattern.compile("<rmember4>");

    public ExamProtocolReport(Group group, String[] members) {
        this.group = group;
        this.members = members;
        this.rmembers = new String[members.length];

        String big_space_for_sign = "                              ";
        for (int i = 0; i < members.length; i++) {
            if (members[i].trim().isEmpty()) {
                continue;
            }
            String[] split = members[i].split(" ");
            rmembers[i] = split[0] + big_space_for_sign + split[2] + split[1];
        }
    }

    @Override
    public Document generate() throws Exception {
        Document document = new Document(getTemplateFilePath(TEMPLATE_NAME));

        document.getRange().replace(GROUP_NAME, group.getTitle());
        document.getRange().replace(MEMBER1, members[0]);
        document.getRange().replace(MEMBER2, members[1]);
        document.getRange().replace(MEMBER3, members[2]);
        document.getRange().replace(MEMBER4, members[3]);
        document.getRange().replace(REVERS_MEMBER1,rmembers[0]);
        document.getRange().replace(REVERS_MEMBER2,rmembers[1]);
        document.getRange().replace(REVERS_MEMBER3,rmembers[2]);
        document.getRange().replace(REVERS_MEMBER4,rmembers[3]);

        Table mainTable = (Table) document.getChild(NodeType.TABLE, 0, true);
        Row lastRow = mainTable.getLastRow();
        Integer number = 1;
        ArrayList<Student> students = new ArrayList<Student>(group.getStudents());
        Collections.sort(students, new StudentComparator());

        for (Student student : students) {
            mainTable.appendChild(lastRow.deepClone(true));
            String fio = student.getLastName() + " "
                    + student.getFirstName().charAt(0) + "."
                    + student.getMiddleName().charAt(0) + ".";
            lastRow.getRange().replace(NUMBER, number.toString());
            lastRow.getRange().replace(FIO, fio);
            number++;
            lastRow = mainTable.getLastRow();
        }
        mainTable.removeChild(lastRow);

        Table table = (Table) document.getChild(NodeType.TABLE, 1, true);
        lastRow = table.getLastRow();
        number = 1;
        boolean isFullTable = students.size() % 2 == 0;
        int rowCount = isFullTable ? students.size() / 2 : students.size() / 2 + 1;
        for (int i = 0; i < rowCount; i++) {
            table.appendChild(lastRow.deepClone(true));
            Student student = students.get(i);
            String fio = student.getLastName() + " "
                    + student.getFirstName() + " "
                    + student.getMiddleName();
            lastRow.getCells().get(0).getRange().replace(NUMBER, number.toString());
            lastRow.getCells().get(1).getRange().replace(FIO, fio);
            number++;
            lastRow = table.getLastRow();
        }

        table.removeChild(table.getLastRow());

        for (int i = rowCount; i < students.size(); i++) {
            lastRow = table.getRows().get(1 + i - rowCount);
            Student student = students.get(i);
            String fio = student.getLastName() + " "
                    + student.getFirstName() + " "
                    + student.getMiddleName();
            lastRow.getCells().get(2).getRange().replace(NUMBER, number.toString());
            lastRow.getCells().get(3).getRange().replace(FIO, fio);
            number++;
        }
        if (!isFullTable) {
            table.getLastRow().getCells().get(2).getRange().replace(NUMBER, number.toString());
            table.getLastRow().getCells().get(3).removeAllChildren();
        }

        return document;
    }
}
