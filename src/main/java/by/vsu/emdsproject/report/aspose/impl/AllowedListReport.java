package by.vsu.emdsproject.report.aspose.impl;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.report.aspose.AsposeReport;
import com.aspose.words.*;

import java.util.regex.Pattern;

public class AllowedListReport extends AsposeReport {

    public static final String TEMPLATE_NAME = "AllowedList.docx";

    public static final Pattern LIST_START = Pattern.compile("<startList>");
    public static Pattern GROUP_NAME = Pattern.compile("<groupName>");
    public static Pattern VUS = Pattern.compile("<vus>");
    public static Pattern PROFILE = Pattern.compile("<profile>");
    public static Pattern CHIEF = Pattern.compile("<chief>");
    public static Pattern FACULTY = Pattern.compile("<faculty>");

    private Group group;
    private Teacher chief;

    public AllowedListReport(Group group, Teacher chief) {
        this.group = group;
        this.chief = chief;
    }

    @Override
    public Document generate() throws Exception {
        Document document = new Document(getTemplateFilePath(TEMPLATE_NAME));
        document.getRange().replace(GROUP_NAME, group.getTitle());
        document.getRange().replace(VUS, group.getSpecialty().getNumber());
        document.getRange().replace(PROFILE, group.getSpecialty().getDescription());

        String chiefLabel = chief.getRank();
        chiefLabel += "                                                                 ";
        chiefLabel += ReportUtil.getReversShortFIO(chief);
        document.getRange().replace(CHIEF, chiefLabel);
        Student s = (Student) group.getStudents().toArray()[0];
        String faculty = s.getQuestionnaire().getFaculty();
        document.getRange().replace(FACULTY, ReportUtil.getFacultyInCase(faculty));

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
        for (Student student : group.getStudents()) {
            builder.writeln(ReportUtil.getFullFIO(student));
        }
        builder.getListFormat().removeNumbers();

        return document;
    }
}
