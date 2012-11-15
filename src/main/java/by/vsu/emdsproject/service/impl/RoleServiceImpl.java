package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.dao.RoleDAO;
import by.vsu.emdsproject.model.Role;
import by.vsu.emdsproject.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDAO roleDAO;
    
    @Transactional
    public void add(Role entity) {
        roleDAO.save(entity);
    }

    @Transactional
    public void update(Role entity) {
        roleDAO.update(entity);
    }

    @Transactional
    public List<Role> list() {
        return roleDAO.findAll();
    }

    @Transactional
    public Role read(Long id) {
        return roleDAO.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        roleDAO.deleteById(id);
    }

    @Transactional
    public void remove(Role entity) {
        roleDAO.delete(entity);
    }

    @Transactional
    public Role getByName(String name){
        return roleDAO.getByName(name);
    }
    
}
