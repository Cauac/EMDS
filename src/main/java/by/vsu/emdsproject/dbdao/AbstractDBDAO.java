package by.vsu.emdsproject.dbdao;

import by.vsu.emdsproject.dao.AbstractDAO;
import by.vsu.emdsproject.model.AbstractEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDBDAO<TypeEn extends AbstractEntity> implements AbstractDAO<TypeEn> {

    @Autowired
    protected static SessionFactory sessionFactory;
    protected Session session;

    @Override
    public void create(TypeEn e) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(e);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public TypeEn read(Long id) {

        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class realType = (Class) pt.getActualTypeArguments()[0];

        session = sessionFactory.openSession();
        Transaction transaction = null;
        TypeEn e = null;
        try {
            transaction = session.beginTransaction();
            e = (TypeEn) session.get(realType.getClass(), id);
            transaction.commit();
            return e;
        } catch (HibernateException ex) {
            transaction.rollback();
            return e;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(TypeEn e) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(e);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(TypeEn e) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(e);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<TypeEn> getList() {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<TypeEn> result;
        try {
            transaction = session.beginTransaction();
            result = session.createQuery("FROM Speciality").list();
            transaction.commit();
            return result;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new RuntimeException(ex.getLocalizedMessage());
        } finally {
            session.close();
        }
    }
}