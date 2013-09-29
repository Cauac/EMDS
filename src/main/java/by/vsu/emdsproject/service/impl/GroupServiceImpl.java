package by.vsu.emdsproject.service.impl;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.repository.GroupRepository;
import by.vsu.emdsproject.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Group> list() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Group read(Long id) {
        return groupRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        groupRepository.delete(id);
    }

    @Override
    public void remove(Group group) {
        groupRepository.delete(group);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Group> findBySpecialty(Specialty specialty) {
        return groupRepository.findBySpecialty(specialty);
    }
}
