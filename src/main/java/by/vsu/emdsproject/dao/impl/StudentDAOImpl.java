package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.model.Student;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl extends AbstractDAOImpl<Student> implements StudentDAO {

    public StudentDAOImpl() {
        super();
        setClazz(Student.class);
    }

    public List<Student> getAbiturients() {
        return getCurrentSession().createCriteria(Student.class)
                .add(Restrictions.like("rank", "abiturient")).list();
    }
    
    public List<Student> getStudents() {
        return getCurrentSession().createCriteria(Student.class)
                .add(Restrictions.like("rank", "%student")).list();
    }
    
}
