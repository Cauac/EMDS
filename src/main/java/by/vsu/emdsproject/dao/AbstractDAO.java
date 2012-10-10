package by.vsu.emdsproject.dao;

import java.util.List;

public interface AbstractDAO<Entity> {

    void create(Entity e);

    Entity read(Long id);

    void update(Entity e);

    void delete(Entity e);

    List<Entity> getList();
}
