package by.vsu.emdsproject.common;

import com.mongodb.DBObject;

import java.util.Comparator;

public class StudentComparator implements Comparator<Object> {

    public StudentComparator() {
    }

    @Override
    public int compare(Object o1, Object o2) {
        DBObject st1 = (DBObject) o1;
        DBObject st2 = (DBObject) o2;
        String fio1 = "" + st1.get("last_name") + st1.get("first_name") + st1.get("middle_name");
        String fio2 = "" + st2.get("last_name") + st2.get("first_name") + st2.get("middle_name");
        return fio1.compareTo(fio2);
    }
}
