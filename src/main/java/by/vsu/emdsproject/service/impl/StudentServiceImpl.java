package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.repository.StudentRepository;
import by.vsu.emdsproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Student read(Long id) {
        return studentRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        studentRepository.delete(id);
    }

    @Transactional
    public void remove(Student student) {
        studentRepository.delete(student);
    }

    @Transactional
    public List<Student> getStudents() {
        return studentRepository.findByRank(Student.STUDENT);
    }

    @Transactional
    public List<Student> getAbiturients() {
        return studentRepository.findByRank(Student.ABITURIENT);
    }
}
