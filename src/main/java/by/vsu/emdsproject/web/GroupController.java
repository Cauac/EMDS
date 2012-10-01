/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.vsu.emdsproject.web;

import by.vsu.emdsproject.model.Group;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Max
 */
@Controller
public class GroupController {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @RequestMapping("/allGroups.htm")
    public ModelAndView allGroups() {
        List<Group> groups = sessionFactory.getCurrentSession().
                createQuery("FROM Group").list();

        ModelAndView mav = new ModelAndView("group/groupList");
        mav.addObject("groups", groups);
        return mav;
    }
    
}
