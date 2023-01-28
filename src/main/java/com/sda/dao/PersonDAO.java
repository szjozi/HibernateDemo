package com.sda.dao;

import com.sda.db.HibernateUtils;
import com.sda.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDAO {

    public List<Person> findAll() {
        Session session = HibernateUtils.openSession();

        String selectQuery = "SELECT p FROM Person p";

        List<Person> people = session.createQuery(selectQuery, Person.class)
                .list();

        session.close();
        return people;
    }

//    Shorter version of findAll method with use of try-with-resources.

//    public List<Person> findAll() {
//        try (Session session = HibernateUtils.openSession()) {
//            return session.createQuery("FROM Person p", Person.class)
//                    .list();
//        }
//    }


    public Person findById(Long id) {
        Session session = HibernateUtils.openSession();
        Person person = session.find(Person.class, id);

//        The same result can be also achieved with following code:

//        String query = "SELECT p FROM Person p WHERE p.id = :id";
//
//        Person person = session.createQuery(query, Person.class)
//                .setParameter("id", id)
//                .getSingleResult();


        session.close();
        return person;
    }

    public void create(Person person) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(person);

        transaction.commit();
        session.close();
    }
}
