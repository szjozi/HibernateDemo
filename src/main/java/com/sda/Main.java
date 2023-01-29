package com.sda;

import com.sda.dao.AddressDAO;
import com.sda.model.Address;
import com.sda.model.Person;

public class Main {

    public static void main(String[] args) {
//        PersonDAO personDAO = new PersonDAO();

        AddressDAO addressDAO = new AddressDAO();

        Person person = new Person();
        person.setId(1L);


        Address address = new Address();
        address.setCity("Manchester");
        address.setHouseNo("7");
        address.setStreet("Duchy View");
        address.setPostCode("PL15 7BQ");
        address.setPerson(person);

        addressDAO.create(address);

    }
}
