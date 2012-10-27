package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.TeacherDAO;
import by.vsu.emdsproject.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDAOImpl extends AbstractDAOImpl<Teacher> implements TeacherDAO {

    public TeacherDAOImpl() {
        setClazz(Teacher.class);
    }
}
