package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.repository.GroupRepository;
import by.vsu.emdsproject.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Transactional
    public Group add(Group group) {
        return groupRepository.save(group);
    }

    @Transactional
    public Group update(Group group) {
        return groupRepository.save(group);
    }

    @Transactional(readOnly = true)
    public List<Group> list() {
        return groupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Group read(Long id) {
        return groupRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        groupRepository.delete(id);
    }

    @Transactional
    public void remove(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public List<Group> findBySpecialty(Specialty specialty) {
        return groupRepository.findBySpecialty(specialty);
    }
}
