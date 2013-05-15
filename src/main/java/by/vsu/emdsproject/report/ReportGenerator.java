package by.vsu.emdsproject.report;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.model.Teacher;

import javax.servlet.http.HttpServletResponse;

public interface ReportGenerator {

    public void generatePersonCardReport(Student student, HttpServletResponse response);

    public void generateExamStatementReport(Group group, Teacher chief, HttpServletResponse response);

    public void generateExamProtocolReport(Group group, String[] members, HttpServletResponse response);

    public void generateAllowedListReport(Group group, HttpServletResponse response);
}
