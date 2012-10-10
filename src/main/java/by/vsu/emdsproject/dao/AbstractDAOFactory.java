package by.vsu.emdsproject.dao;

public interface AbstractDAOFactory {

    AddressDAO getAddressDAO();

    GroupDAO getGroupDAO();

    SpecialityDAO getSpecialtyDAO();

    StudentDAO getStudentDAO();

    SubjectDAO getSubjectDAO();

    TeacherDAO getTeacherDAO();
}
