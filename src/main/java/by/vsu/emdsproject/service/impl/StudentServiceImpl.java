package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Document;
import by.vsu.emdsproject.model.DocumentInfo;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.repository.DocumentInfoRepository;
import by.vsu.emdsproject.repository.DocumentRepository;
import by.vsu.emdsproject.repository.StudentRepository;
import by.vsu.emdsproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentInfoRepository documentInfoRepository;

    @Override
    public Student save(Student student) {
        if (student.getDocuments().isEmpty()) {
            for (Document document : documentRepository.findAll()) {
                DocumentInfo documentInfo = new DocumentInfo(false, "");
                documentInfoRepository.save(documentInfo);
                student.getDocuments().put(document, documentInfo);
            }
        }
        return studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "students", key = "#id")
    public Student read(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        Student toRemove = studentRepository.findOne(id);
        toRemove.getDocuments().clear();
        studentRepository.delete(toRemove);
    }

    @Override
    public void remove(Student student) {
        student.getDocuments().clear();
        studentRepository.delete(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAbiturients() {
        return studentRepository.findByType(Student.ABITURIENT);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getJuniors() {
        return studentRepository.findByType(Student.JUNIOR);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getOfficers() {
        return studentRepository.findByType(Student.OFFICER);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getReserve() {
        return studentRepository.findByType(Student.RESERVE);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getDismissed() {
        return studentRepository.findByType(Student.DISMISSED);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getFailed() {
        return studentRepository.findByType(Student.FAILED);
    }

    @Override
    public void toJunior(Student student) {
        student.setType(Student.JUNIOR);
        studentRepository.save(student);
    }

    @Override
    public void toOfficer(Student student) {
        student.setType(Student.OFFICER);
        studentRepository.save(student);
    }

    @Override
    public void toReserve(Student student) {
        student.setType(Student.RESERVE);
        studentRepository.save(student);
    }

    @Override
    public void fail(Student student) {
        student.setType(Student.FAILED);
        studentRepository.save(student);
    }

    @Override
    public void dismiss(Student student) {
        student.setType(Student.DISMISSED);
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByGroup(Group group) {
        return studentRepository.findByGroup(group);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean readyToTake(Student abiturient) {
        Student student = studentRepository.findOne(abiturient.getId());
        for (Document document : documentRepository.findAll()) {
            if (!student.getDocuments().get(document).getBrought()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Student> getAbiturientsByFaculty(String faculty) {
        return studentRepository.findByQuestionnaireFacultyAndType(faculty, Student.ABITURIENT);
    }
}
