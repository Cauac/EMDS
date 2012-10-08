/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.vsu.emdsproject.dao;

/**
 *
 * @author Max
 */
public interface AbstractDAOFactory {
    AddressDAO getAddressDAO();
    GroupDAO getGroupDAO();
    SpecialityDAO getSpecialtyDAO();
    StudentDAO getStudentDAO();
    SubjectDAO getSubjectDAO();
    TeacherDAO getTeacherDAO();
}
