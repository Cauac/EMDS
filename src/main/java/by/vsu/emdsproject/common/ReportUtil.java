package by.vsu.emdsproject.common;

import by.vsu.emdsproject.model.Person;
import com.mongodb.DBObject;

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

    public static String getFullFIO(DBObject o) {
        return String.format("%s %s %s", o.get("last_name"), o.get("first_name"), o.get("middle_name"));
    }

    public static String printAddress(Object o) {
        if (o == null) return "";
        DBObject adr = (DBObject) o;
        return String.format("%s ул. %s д. %s кв. %s", getString(adr, "city"), getString(adr, "street"), getString(adr, "house"), getString(adr, "apartment"));
    }

    public static String getString(DBObject o, String field) {
        Object value = o.get(field);
        return value != null ? value.toString() : "";
    }

    public static String getYearFromDate(DBObject o, String field) {
        Object value = o.get(field);
        if (value != null && value.toString().length() > 6) {
            return value.toString().substring(6);
        }
        return "";
    }

    public static String getShortFIO(DBObject o) {
        return String.format("%s %s.%s.", o.get("last_name"), o.get("first_name").toString().charAt(0), o.get("middle_name").toString().charAt(0));
    }

    public static String getReversShortFIO(DBObject o) {
        return String.format("%s.%s. %s", o.get("first_name").toString().charAt(0), o.get("middle_name").toString().charAt(0), o.get("last_name"));
    }
}
