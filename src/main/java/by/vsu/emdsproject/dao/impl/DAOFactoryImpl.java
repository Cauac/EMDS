/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.AbstractDAOFactory;
import by.vsu.emdsproject.dao.AddressDAO;
import by.vsu.emdsproject.dao.GroupDAO;
import by.vsu.emdsproject.dao.SpecialityDAO;
import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.dao.SubjectDAO;
import by.vsu.emdsproject.dao.TeacherDAO;

/**
 *
 * @author Max
 */
public class DAOFactoryImpl implements AbstractDAOFactory {

    public GroupDAO getGroupDAO() {
        return new GroupDAOImpl();
    }

    public SpecialityDAO getSpecialtyDAO() {
        return new SpecialityDAOImpl();
    }

    public SubjectDAO getSubjectDAO() {
        return new SubjectDAOImpl();
    }

    public AddressDAO getAddressDAO() {
        return new AddressDAOImpl();
    }

    public StudentDAO getStudentDAO() {
        return new StudentDAOImpl();
    }

    public TeacherDAO getTeacherDAO() {
        return new TeacherDAOImpl();
    }
}
