package by.vsu.emdsproject.model.comparator;

import by.vsu.emdsproject.model.Teacher;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Сортирует преподавателей по званию
 */
public class TeacherComporator implements Comparator<Teacher> {

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
    public int compare(Teacher o1, Teacher o2) {
        if (o1.getChief()) {
            return -1;
        }
        if (o2.getChief()) {
            return 1;
        }
        Integer r1 = priorityMap.get(o1.getRank());
        Integer r2 = priorityMap.get(o2.getRank());
        return r2.compareTo(r1);
    }
}
