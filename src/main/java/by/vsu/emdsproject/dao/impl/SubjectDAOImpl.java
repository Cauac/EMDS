/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.dao.impl;

import by.vsu.emdsproject.dao.SubjectDAO;
import by.vsu.emdsproject.model.Subject;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Max
 */
@Repository
public class SubjectDAOImpl extends AbstractDAOImpl<Subject> implements SubjectDAO {

    public SubjectDAOImpl() {
        setClazz(Subject.class);
    }
    
}
