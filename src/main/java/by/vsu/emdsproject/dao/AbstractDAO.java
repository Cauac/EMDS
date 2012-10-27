package by.vsu.emdsproject.dao;

import java.util.List;

public interface AbstractDAO<Entity> {

    public Entity findOne(final Long id);

    public List<Entity> findAll();

    public void save(Entity entity);

    public void update(Entity entity);

    public void delete(Entity entity);

    public void deleteById(Long entityId);
}
