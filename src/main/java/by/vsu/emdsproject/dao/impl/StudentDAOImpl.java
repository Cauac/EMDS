/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.model.Student;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Max
 */
@Repository
public class StudentDAOImpl extends AbstractDAOImpl<Student> implements StudentDAO {
    
    public StudentDAOImpl() {
        setClazz(Student.class);
    }
    
}
