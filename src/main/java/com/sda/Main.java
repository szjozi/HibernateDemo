package com.sda;

import com.sda.dao.AddressDAO;
import com.sda.dao.PersonDAO;
import com.sda.enums.Gender;
import com.sda.model.Address;
import com.sda.model.Person;

public class Main {

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        AddressDAO addressDAO = new AddressDAO();

        Person person = new Person();
        person.setAge(35);
        person.setName("Sue");
        person.setGender(Gender.FEMALE);
        person.setSurname("Smith");

        personDAO.create(person);

        Address address = new Address();
        address.setCity("City");
        address.setStreet("Street");
        address.setPostCode("30-405");
        address.setPerson(person);

        addressDAO.create(address);

    }
}
