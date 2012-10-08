/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dbdao;

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
public class DBDAOFactory implements AbstractDAOFactory {

    public GroupDAO getGroupDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SpecialityDAO getSpecialtyDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SubjectDAO getSubjectDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public AddressDAO getAddressDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public StudentDAO getStudentDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TeacherDAO getTeacherDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
