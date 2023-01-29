package com.sda.dao;

import com.sda.db.HibernateUtils;
import com.sda.model.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressDAO {

    public void create(Address address) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(address);

        transaction.commit();
        session.close();
    }

    public boolean deleteById(Long id) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Address address = session.find(Address.class, id);
        boolean exits = address != null;

        if (exits) {
            session.remove(address);
        }

        transaction.commit();
        session.close();
        return exits;
    }

    public int deleteAllByPersonId(Long id) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        String query = "DELETE FROM Address a WHERE a.person.id = :person_id";

        int deleted = session.createMutationQuery(query)
                .setParameter("person_id", id)
                .executeUpdate();

        transaction.commit();
        session.close();
        return deleted;
    }

    public List<Address> findAllByPersonId(Long id){
        Session session = HibernateUtils.openSession();

//        String querySQL = "SELECT * FROM address a WHERE a.person_id = :person_id";
//        List<Address> addresses = session.createNativeQuery(querySQL, Address.class)
//                .setParameter("person_id", id)
//                .list();

        String queryHQL = "SELECT a FROM Address a WHERE a.person.id = :person_id";
        List<Address> addresses = session.createQuery(queryHQL, Address.class)
                .setParameter("person_id", id)
                .list();

        session.close();
        return addresses;
    }
}
