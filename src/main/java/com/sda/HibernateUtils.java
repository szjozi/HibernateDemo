package com.sda;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory == null ? createSession() : sessionFactory;
    }

    private static SessionFactory createSession() {
        Properties properties = getHibernateConfigs();
        Configuration configuration = new Configuration()
                .addProperties(properties);

        return configuration.buildSessionFactory();
    }

    private static Properties getHibernateConfigs() {
        Properties properties = new Properties();
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "pass");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/mydata");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        return properties;
    }
}