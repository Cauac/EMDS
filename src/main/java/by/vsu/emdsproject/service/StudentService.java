package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Student;

import java.util.List;

public interface StudentService extends AbstractService<Student> {

    List<Student> getStudents();

    List<Student> getAbiturients();

    boolean readyToTake(Student abiturient);
}
