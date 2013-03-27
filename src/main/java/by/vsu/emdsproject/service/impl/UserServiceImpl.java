package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.repository.UserRepository;
import by.vsu.emdsproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void add(User entity) {
        userRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<User> list() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User read(Long id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        userRepository.delete(id);
    }

    @Transactional
    public void remove(User entity) {
        userRepository.delete(entity);
    }

    @Transactional
    public void update(User entity) {
        userRepository.save(entity);
    }

    public void addUser(String personType, Long personId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Transactional(readOnly = true)
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional(readOnly = true)
    public List<User> getStudents() {
        return userRepository.findByPersonType("student");
    }

    @Transactional(readOnly = true)
    public List<User> getTeachers() {
        return userRepository.findByPersonType("teacher");
    }

    @Transactional(readOnly = true)
    public User getByStudentId(Long personId) {
        return userRepository.findByPersonTypeAndId("student", personId);
    }

    @Transactional(readOnly = true)
    public User getByTeacherId(Long personId) {
        return userRepository.findByPersonTypeAndId("teacher", personId);
    }
}
