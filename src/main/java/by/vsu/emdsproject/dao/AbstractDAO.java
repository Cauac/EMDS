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

    void create(Entity e);

    Entity read(Long id);

    void update(Entity e);

    void delete(Long id);

    List<Entity> getList();
}
