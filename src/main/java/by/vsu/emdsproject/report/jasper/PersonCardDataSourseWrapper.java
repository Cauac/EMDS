package by.vsu.emdsproject.report.jasper;

import by.vsu.emdsproject.model.Student;
import java.util.HashMap;

/**
 *
 * вытягивает все необходимые данные для отчета и заполняет map
 */
public class PersonCardDataSourseWrapper {

    private Student student;
    public static final String templateName = "r1";

    public static class Parametr {

        public static final String FIO = "fio";
    }

    public PersonCardDataSourseWrapper(Student student) {
        this.student = student;
    }

    public HashMap getDataSource() {
        HashMap map = new HashMap();
        map.put(Parametr.FIO, student.getLastName() + " " + student.getFirstName() + " " + student.getMiddleName());
        return map;
    }
}
