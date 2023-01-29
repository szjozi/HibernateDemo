package com.sda.dao;

import com.sda.db.HibernateUtils;
import com.sda.model.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarDAO {


    public void create(Car car) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(car);

        transaction.commit();
        session.close();
    }
}
