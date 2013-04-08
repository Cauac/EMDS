package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.common.PasswordUtils;
import by.vsu.emdsproject.common.Transliterator;
import by.vsu.emdsproject.model.Person;
import by.vsu.emdsproject.model.Role;
import by.vsu.emdsproject.model.User;
import by.vsu.emdsproject.repository.RoleRepository;
import by.vsu.emdsproject.repository.UserRepository;
import by.vsu.emdsproject.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public User addUserToPerson(String personType, Person person) {
        Role role;
        if (StringUtils.equals(personType, User.STUDENT)) {
            role = roleRepository.findByAuthority(Role.STUDENT);
        } else {
            role = roleRepository.findByAuthority(Role.TEACHER);
        }
        String username = Transliterator.transliterate(person.getLastName()
                + person.getFirstName().charAt(0) + person.getMiddleName().charAt(0));
        User user = new User(person.getId(), personType, username,
                PasswordUtils.encode("12345"), User.ENABLED, role);
        user.setDefaultPassword(true);
        return userRepository.save(user);
    }

    @Transactional
    public User add(User entity) {
        return userRepository.save(entity);
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
    public User update(User entity) {
        return userRepository.save(entity);
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

    public boolean changePassword(String oldPassword, String newPassword, String confirm) {
        User currentUser = userRepository.findByLogin(EMDSContext.getInstance().getCurrentUser().getUsername());
        if (currentUser.getPassword().equals(PasswordUtils.encode(oldPassword)) && newPassword.equals(confirm)) {
            currentUser.setPassword(PasswordUtils.encode(newPassword));
            currentUser.setDefaultPassword(false);
            userRepository.save(currentUser);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public User getUserByStudentId(Long personId) {
        return userRepository.findByPersonTypeAndPersonId("student", personId);
    }

    @Transactional(readOnly = true)
    public User getUserByTeacherId(Long personId) {
        return userRepository.findByPersonTypeAndPersonId("teacher", personId);
    }
}
