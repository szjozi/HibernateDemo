package com.sda;

import com.sda.dao.CarDAO;
import com.sda.dao.PersonDAO;
import com.sda.model.Car;
import com.sda.model.Equipment;
import com.sda.model.Person;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        CarDAO carDAO = new CarDAO();

        Person sue = personDAO.findById(1L);
        Person bob = personDAO.findById(2L);

        Set<Person> carOwners = Set.of(sue, bob);

        Equipment equipment = new Equipment();
        equipment.setNumOfSeats(4);
        equipment.setWinterTires(true);

        Car mercedes = Car.builder()
                .equipment(equipment)
                .make("Mercedes")
                .model("CLS")
                .color("Black")
                .people(carOwners)
                .build();

        carDAO.create(mercedes);

//        Person person = new Person();
//        person.setName("Sue");
//        person.setSurname("Smith");
//        person.setGender(Gender.FEMALE);
//        person.setAge(28);
//
//        personDAO.create(person);


    }
}
