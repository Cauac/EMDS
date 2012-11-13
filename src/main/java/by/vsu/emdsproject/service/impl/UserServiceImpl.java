package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.UserDAO;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDao;
    
    @Transactional
    public void add(User entity) {
        userDao.save(entity);
    }
    
    @Transactional
    public List<User> list() {
        return userDao.findAll();
    }

    @Transactional
    public User read(Long id) {
        return userDao.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        userDao.deleteById(id);
    }

    @Transactional
    public void remove(User entity) {
        userDao.delete(entity);
    }

    @Transactional
    public User getByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Transactional
    public List<User> getStudents() {
        return userDao.getStudents();
    }

    @Transactional
    public List<User> getTeachers() {
        return userDao.getTeachers();
    }

    public void update(User entity) {
        userDao.update(entity);
    }
    
}
