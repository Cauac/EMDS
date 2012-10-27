/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao;

import java.util.List;

/**
 *
 * @author Max
 */
public interface AbstractDAO<Entity> {

    public Entity findOne(final Long id);

    public List<Entity> findAll();

    public void save(Entity entity);

    public void update(Entity entity);

    public void delete(Entity entity);

    public void deleteById(Long entityId);
}
