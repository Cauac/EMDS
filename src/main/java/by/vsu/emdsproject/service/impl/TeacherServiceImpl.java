package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.exception.EMDSException;
import by.vsu.emdsproject.model.Teacher;
import by.vsu.emdsproject.repository.TeacherRepository;
import by.vsu.emdsproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher add(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional(readOnly = true)
    public List<Teacher> list() {
        return teacherRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Teacher read(Long id) {
        return teacherRepository.findOne(id);
    }

    public void remove(Long id) {
        teacherRepository.delete(id);
    }

    public void remove(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    public Teacher update(Teacher entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public Teacher getChief() {
        List<Teacher> chiefs = teacherRepository.findByChief(true);
        if(chiefs.isEmpty()) throw new EMDSException("Нужно назначить начальника кафедры");
        return chiefs.get(0);
    }
}
