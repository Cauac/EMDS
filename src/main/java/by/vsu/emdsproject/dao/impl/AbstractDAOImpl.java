package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.AbstractDAO;
import by.vsu.emdsproject.model.AbstractEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAOImpl<TypeEn extends AbstractEntity> implements AbstractDAO<TypeEn> {

    private Class<TypeEn> clazz;
    @Autowired
    private SessionFactory sessionFactory;

    public void setClazz(final Class<TypeEn> clazzToSet) {
        clazz = clazzToSet;
    }

    @SuppressWarnings("unchecked")
    public TypeEn findOne(final Long id) {
        return (TypeEn) getCurrentSession().load(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<TypeEn> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public void save(TypeEn entity) {
        getCurrentSession().save(entity);
    }

    public void update(TypeEn entity) {
        getCurrentSession().merge(entity);
    }

    public void delete(TypeEn entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(Long entityId) {
        TypeEn entity = findOne(entityId);
        delete(entity);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}