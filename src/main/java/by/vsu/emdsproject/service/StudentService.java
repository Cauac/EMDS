package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;

import java.util.List;

public interface StudentService extends AbstractService<Student> {

    List<Student> getAbiturients();

    List<Student> getJuniors();

    List<Student> getOfficers();

    List<Student> getReserve();

    List<Student> getFailed();

    List<Student> getDismissed();

    List<Student> findByGroup(Group group);

    boolean readyToTake(Student abiturient);

    void toJunior(Student student);

    void toOfficer(Student student);

    void toReserve(Student student);

    void fail(Student student);

    void dismiss(Student student);
}
