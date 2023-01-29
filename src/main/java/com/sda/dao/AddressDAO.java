package com.sda.dao;

import com.sda.db.HibernateUtils;
import com.sda.model.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddressDAO {

    public void create(Address address) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(address);

        transaction.commit();
        session.close();
    }
}
