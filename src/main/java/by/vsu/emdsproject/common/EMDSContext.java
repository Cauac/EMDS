package by.vsu.emdsproject.common;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class EMDSContext {

    private final static EMDSContext instance = new EMDSContext();
    private final static ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring/emds-web-context.xml");
    private final static ConfigurableEnvironment environment = factory.getEnvironment();

    private EMDSContext() {
    }

    public static EMDSContext getInstance() {
        return instance;
    }

    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public BeanFactory getFactory() {
        return factory;
    }

    public Environment getEnvironment(){
        return environment;
    }

}
