package by.vsu.emdsproject.common;

import com.mongodb.DBObject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Сортирует преподавателей по званию
 */
public class TeacherComparator implements Comparator<Object> {

    private final static Map<String, Integer> priorityMap = new HashMap<String, Integer>();

    static {
        priorityMap.put("Младший лейтенант", 1);
        priorityMap.put("Лейтенант", 2);
        priorityMap.put("Старший лейтенант", 3);
        priorityMap.put("Капитан", 4);
        priorityMap.put("Майор", 5);
        priorityMap.put("Подполковник", 6);
        priorityMap.put("Полковник", 7);
    }

    @Override
    public int compare(Object o1, Object o2) {
        DBObject t1 = (DBObject) o1;
        DBObject t2 = (DBObject) o2;
        if ((Boolean) t1.get("is_chief")) {
            return -1;
        }
        if ((Boolean) t2.get("is_chief")) {
            return 1;
        }
        Integer r1 = priorityMap.get(t1.get("rank"));
        Integer r2 = priorityMap.get(t2.get("rank"));
        return r2.compareTo(r1);
    }
}
