package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.model.Role;

public interface RoleDAO extends AbstractDAO<Role> {

    public Role getByName(String name);
}
