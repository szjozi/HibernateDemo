package com.sda;

import com.sda.dao.PersonDAO;
import com.sda.enums.Gender;
import com.sda.model.Person;

public class Main {

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        Person person = new Person();
        person.setAge(30);
        person.setName("Kate");
        person.setGender(Gender.FEMALE);
        person.setSurname("Smith");

        personDAO.create(person);
    }
}
