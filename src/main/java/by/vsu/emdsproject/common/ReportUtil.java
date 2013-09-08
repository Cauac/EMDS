package by.vsu.emdsproject.common;

import by.vsu.emdsproject.model.Person;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        facultyCase.put("Художественно-графический", "художественно-графического факультета");
        facultyCase.put("Педагогический", "педагогического факультета");

        return facultyCase.get(faculty);
    }

    public static String getFullFacultyName(String faculty) {
        Map<String, String> facultyCase = new HashMap<String, String>();

        facultyCase.put("Математический", "Математический факультет");
        facultyCase.put("Физический", "Физический факультет");
        facultyCase.put("Биологический", "Биологический факультет");
        facultyCase.put("Физической культуры и спорта", "Факультет физической культуры и спорта");
        facultyCase.put("Исторический", "Исторический факультет");
        facultyCase.put("Социальной педагогики и психологии", "Факультет социальной педагогики и психологии");
        facultyCase.put("Филологический", "Филологический факультет");
        facultyCase.put("Белорусской филологии и культры", "Факультет белорусской филологии и культры");
        facultyCase.put("Юридический", "Юридический факультет");
        facultyCase.put("Художественно-графический", "Художественно-графический факультет");
        facultyCase.put("Педагогический", "Педагогический факультет");

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

    public static String getYearInString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

}
