package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Role;
import by.vsu.emdsproject.repository.RoleRepository;
import by.vsu.emdsproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void add(Role entity) {
        roleRepository.save(entity);
    }

    @Transactional
    public void update(Role entity) {
        roleRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Role read(Long id) {
        return roleRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        roleRepository.delete(id);
    }

    @Transactional
    public void remove(Role entity) {
        roleRepository.delete(entity);
    }

    @Transactional
    public Role getByName(String name) {
        return roleRepository.findByAuthority(new Role(name));
    }
}
