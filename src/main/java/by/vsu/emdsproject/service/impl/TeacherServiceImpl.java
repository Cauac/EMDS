package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.repository.TeacherRepository;
import by.vsu.emdsproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public void add(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Transactional(readOnly = true)
    public List<Teacher> list() {
        return teacherRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Teacher read(Long id) {
        return teacherRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        teacherRepository.delete(id);
    }

    @Transactional
    public void remove(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Transactional
    public void update(Teacher entity) {
        teacherRepository.save(entity);
    }
}
