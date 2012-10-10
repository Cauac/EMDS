package by.vsu.emdsproject.dbdao;

import by.vsu.emdsproject.dao.AbstractDAOFactory;
import by.vsu.emdsproject.dao.AddressDAO;
import by.vsu.emdsproject.dao.GroupDAO;
import by.vsu.emdsproject.dao.SpecialityDAO;
import by.vsu.emdsproject.dao.StudentDAO;
import by.vsu.emdsproject.dao.SubjectDAO;
import by.vsu.emdsproject.dao.TeacherDAO;

public final class DBDAOFactory implements AbstractDAOFactory {

    public GroupDAO getGroupDAO() {
        return new DBGroupDAO();
    }

    public SpecialityDAO getSpecialtyDAO() {
        return new DBSpecialityDAO();
    }

    public SubjectDAO getSubjectDAO() {
        return new DBSubjectDAO();
    }

    public AddressDAO getAddressDAO() {
        return new DBAddressDAO();
    }

    public StudentDAO getStudentDAO() {
        return new DBStudentDAO();
    }

    public TeacherDAO getTeacherDAO() {
        return new DBTeacherDAO();
    }
}
