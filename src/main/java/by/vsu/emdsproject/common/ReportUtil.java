package by.vsu.emdsproject.common;

import by.vsu.emdsproject.model.Person;

import java.util.HashMap;
import java.util.Map;

public class ReportUtil {

    public static String getFacultyInCase(String faculty) {
        Map<String, String> facultyCase = new HashMap<String, String>();

        facultyCase.put("Математический", "математического факультета");
        facultyCase.put("Физический", "физического факультета");
        facultyCase.put("Биологический", "биологического факультета");
        facultyCase.put("Физической культуры и спорта", "факультета физической культуры и спорта");
        facultyCase.put("Исторический", "исторического факультета");
        facultyCase.put("Социальной педагогики и психологии", "факультета социальной педагогики и психологии");
        facultyCase.put("Филологический", "филологического факультета");
        facultyCase.put("Белорусской филологии и культры", "факультета белорусской филологии и культры");
        facultyCase.put("Юридический", "юридического факультета");
        facultyCase.put("Художественно-графический", "Художественно-графического факультета");
        facultyCase.put("Педагогический", "педагогического факультета");

        return facultyCase.get(faculty);
    }

    public static String getFullFIO(Person p) {
        String result = p.getLastName() + " "
                + p.getFirstName() + " "
                + p.getMiddleName();
        return result;
    }

    public static String getShortFIO(Person p) {
        String result = p.getLastName() + " "
                + p.getFirstName().charAt(0) + "."
                + p.getMiddleName().charAt(0) + ".";
        return result;
    }

    public static String getReversShortFIO(Person p) {
        String result = p.getFirstName().charAt(0) + "."
                + p.getMiddleName().charAt(0) + ". "
                + p.getLastName();
        return result;
    }

}
