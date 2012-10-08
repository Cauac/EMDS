/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dbdao;

import by.vsu.emdsproject.dao.AbstractDAO;
import by.vsu.emdsproject.model.AbstractEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Max
 */
public abstract class AbstractDBDAO<TypeEn extends AbstractEntity> implements AbstractDAO<TypeEn> {

    @Autowired
    protected static SessionFactory sessionFactory;
}
