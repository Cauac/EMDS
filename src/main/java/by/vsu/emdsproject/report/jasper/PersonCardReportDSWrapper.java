package by.vsu.emdsproject.report.jasper;

import by.vsu.emdsproject.model.Student;
import java.util.HashMap;

/**
 * вытягивает все необходимые данные для отчета персональной карточки студента
 */
public class PersonCardReportDSWrapper implements ReportDataSourceWrapper {

    private Student student;
    public static final String templateName = "/home/anton/r1.jasper";

    public static class Parametr {

        public static final String FIO = "fio";
    }

    public PersonCardReportDSWrapper(Student student) {
        this.student = student;
    }

    public String getTemplateName() {
        return templateName;
    }

    public HashMap getDataSource() {
        HashMap map = new HashMap();
        map.put(Parametr.FIO, student.getLastName() + " " + student.getFirstName() + " " + student.getMiddleName());
        return map;
    }
}
