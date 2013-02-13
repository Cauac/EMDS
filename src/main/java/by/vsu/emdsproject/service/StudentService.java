package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Questionnaire;
import by.vsu.emdsproject.model.Student;
import java.util.Date;
import java.util.List;

public interface StudentService extends AbstractService<Student> {

    void add(Student s, Date d, Group g, Questionnaire q);

    List<Student> getStudents();

    List<Student> getAbiturients();
}
