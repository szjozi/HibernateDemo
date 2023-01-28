package com.sda.db;

import com.sda.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory == null ? createSession() : sessionFactory;
    }

    private static SessionFactory createSession() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class);

        return configuration.buildSessionFactory();
    }
}