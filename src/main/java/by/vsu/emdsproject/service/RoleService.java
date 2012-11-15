package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Role;

public interface RoleService extends AbstractService<Role> {

    public Role getByName(String name);
}
