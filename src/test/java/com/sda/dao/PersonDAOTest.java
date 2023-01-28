package com.sda.dao;

import com.sda.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonDAOTest {

    private final PersonDAO personDAO = new PersonDAO();

    @Test
    void testCreate() {
        // given
        Person expectedPerson = new Person();
        expectedPerson.setName("Name");
        expectedPerson.setSurname("Surname");

        // when
        personDAO.create(expectedPerson);

        // then
        Long expectedId = expectedPerson.getId();
        Person actualPerson = personDAO.findById(expectedId);

        Assertions.assertNotNull(actualPerson);
        Assertions.assertEquals(expectedPerson.getId(), actualPerson.getId());
        Assertions.assertEquals(expectedPerson.getName(), actualPerson.getName());
        Assertions.assertEquals(expectedPerson.getSurname(), actualPerson.getSurname());

    }
}
