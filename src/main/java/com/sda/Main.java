package com.sda;

import com.sda.dao.AddressDAO;
import com.sda.dao.CarDAO;
import com.sda.dao.PersonDAO;
import com.sda.db.HibernateUtils;
import com.sda.enums.Gender;
import com.sda.model.Address;
import com.sda.model.Car;
import com.sda.model.Equipment;
import com.sda.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        AddressDAO addressDAO = new AddressDAO();
        CarDAO carDAO = new CarDAO();

        System.out.println("\n============== CREATE SUE AND BOB ==============");
        System.out.println("================================================");

        Person person1 = new Person();
        person1.setName("Bob");
        person1.setSurname("Smith");
        person1.setGender(Gender.MALE);
        person1.setAge(35);

        Person person2 = new Person();
        person2.setName("Sue");
        person2.setSurname("Smith");
        person2.setGender(Gender.FEMALE);
        person2.setAge(28);

        personDAO.create(person1);
        personDAO.create(person2);

        System.out.println("\n=============== LIST ALL PEOPLE ================");
        System.out.println("================================================");

        List<Person> allPeople = personDAO.findAll();
        allPeople.forEach(System.out::println);

        System.out.println("\n================ FIND BOB AND SUE ==============");
        System.out.println("================================================");

        Person sue = personDAO.findById(person1.getId());
        Person bob = personDAO.findById(person2.getId());

        System.out.println("SEARCH RESULT: " +  sue);
        System.out.println("SEARCH RESULT: " +  bob);

        System.out.println("\n============ CREATE BOB's ADDRESSES ============");
        System.out.println("================================================");

        Address bobsLondonAddress = new Address();
        bobsLondonAddress.setHouseNo("11");
        bobsLondonAddress.setPostCode("WL7 10PG");
        bobsLondonAddress.setCity("London");
        bobsLondonAddress.setStreet("Piccadilly");
        bobsLondonAddress.setPerson(bob);

        addressDAO.create(bobsLondonAddress);

        Address bobsWarsawAddress = new Address();
        bobsWarsawAddress.setHouseNo("194");
        bobsWarsawAddress.setPostCode("35-102");
        bobsWarsawAddress.setCity("Warsaw");
        bobsWarsawAddress.setStreet("Jana Pawła II");
        bobsWarsawAddress.setPerson(bob);

        addressDAO.create(bobsWarsawAddress);

        System.out.println("\n============ CREATE SUE's ADDRESSES ============");
        System.out.println("================================================");

        Address suesLondonAddress = new Address();
        suesLondonAddress.setHouseNo("20");
        suesLondonAddress.setPostCode("WL7 10PG");
        suesLondonAddress.setCity("London");
        suesLondonAddress.setStreet("Piccadilly");
        suesLondonAddress.setPerson(sue);

        addressDAO.create(suesLondonAddress);

        Address suesWarsawAddress = new Address();
        suesWarsawAddress.setHouseNo("100");
        suesWarsawAddress.setPostCode("35-102");
        suesWarsawAddress.setCity("Warsaw");
        suesWarsawAddress.setStreet("Jana Pawła II");
        suesWarsawAddress.setPerson(sue);

        addressDAO.create(suesWarsawAddress);

        System.out.println("\n============= LIST BOB's ADDRESSES =============");
        System.out.println("================================================");

        Long bobsId = bob.getId();
        List<Address> bobsAddresses = addressDAO.findAllByPersonId(bobsId);
        bobsAddresses.forEach(System.out::println);

        System.out.println("\n============= LIST SUE's ADDRESSES =============");
        System.out.println("================================================");

        Long suesId = sue.getId();
        List<Address> suesAddresses = addressDAO.findAllByPersonId(suesId);
        suesAddresses.forEach(System.out::println);


        System.out.println("\n========== DELETE BOB's ALL ADDRESSES ==========");
        System.out.println("================================================");

        int removedRows = addressDAO.deleteAllByPersonId(bobsId);
        System.out.println("REMOVED ADDRESSES COUNT: " + removedRows);

        System.out.println("\n========= DELETE SUE's LONDON ADDRESS ==========");
        System.out.println("================================================");

        Long suesLondonAddressId = suesLondonAddress.getId();
        boolean removed = addressDAO.deleteById(suesLondonAddressId);
        System.out.println("LONDON ADDRESS REMOVED: " + removed);


        System.out.println("\n============= LIST BOB's ADDRESSES =============");
        System.out.println("================================================");

        addressDAO.findAllByPersonId(bobsId).forEach(System.out::println);

        System.out.println("\n============= LIST SUE's ADDRESSES =============");
        System.out.println("================================================");

        addressDAO.findAllByPersonId(suesId).forEach(System.out::println);

        System.out.println("\n============ CREATE CAR AND RELATE IT WITH SUE AND BOB ============");
        System.out.println("=====================================================================");

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

        // Poniższy kod usuwa wszystkie tabele.
        // Można go od komentować w celu wyczyszczenia tabel.
        // Inna opcja jest zmiana konfiguracji w pliku "hibernate.properties"
        // "hibernate.hbm2ddl.auto" z wartości "update" na "create-drop".

//        System.out.println("\n========= DROP (REMOVE) ALL TABLES ==========");
//        System.out.println("================================================");
//
//        try (Session session = HibernateUtils.openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            session.createNativeQuery("DROP table address", Address.class).executeUpdate();
//            session.createNativeQuery("DROP table car_person", Car.class).executeUpdate();
//            session.createNativeQuery("DROP table car", Car.class).executeUpdate();
//            session.createNativeQuery("DROP table person", Person.class).executeUpdate();
//            transaction.commit();
//        }


    }
}
