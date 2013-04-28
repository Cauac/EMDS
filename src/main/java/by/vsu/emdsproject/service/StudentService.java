package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Student;

import java.util.List;

public interface StudentService extends AbstractService<Student> {

    List<Student> getAbiturients();

    List<Student> getJuniors();

    List<Student> getOfficers();

    List<Student> getReserve();

    List<Student> getFailed();

    boolean readyToTake(Student abiturient);

    void toJunior(Student student);

    void toOfficer(Student student);

    void toReserve(Student student);

    void toArchive(Student student);
}
