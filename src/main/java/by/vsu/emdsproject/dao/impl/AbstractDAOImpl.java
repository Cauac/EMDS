/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.AbstractDAO;
import by.vsu.emdsproject.model.AbstractEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Max
 */
public abstract class AbstractDAOImpl<TypeEn extends AbstractEntity> implements AbstractDAO<TypeEn> {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Transactional(readOnly = false)
    public void save(TypeEn e) {
        hibernateTemplate.saveOrUpdate(e);
    }

    public TypeEn read(Long id) {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class realType = (Class) pt.getActualTypeArguments()[0];
        return (TypeEn) hibernateTemplate.get(realType, id);
    }

    public void delete(TypeEn e) {
        hibernateTemplate.delete(e);
    }

    @Transactional(readOnly = false)
    public List<TypeEn> getList() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class realType = (Class) pt.getActualTypeArguments()[0];
        return (List<TypeEn>) hibernateTemplate.find("from " + realType.getName());
    }
}