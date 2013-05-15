package by.vsu.emdsproject.model.comparator;

import by.vsu.emdsproject.model.Student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    public StudentComparator() {
    }

    @Override
    public int compare(Student o1, Student o2) {
        String fio1 = o1.getLastName() + o1.getFirstName() + o1.getMiddleName();
        String fio2 = o2.getLastName() + o2.getFirstName() + o2.getMiddleName();
        return fio1.compareTo(fio2);
    }
}
