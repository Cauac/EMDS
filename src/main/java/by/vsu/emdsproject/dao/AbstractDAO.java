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

    void save(Entity e);

    Entity read(Long id);

    void delete(Entity e);

    List<Entity> getList();
}
