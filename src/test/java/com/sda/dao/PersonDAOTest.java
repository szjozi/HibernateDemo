package com.sda.dao;

import com.sda.enums.Gender;
import com.sda.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonDAOTest {

    private final PersonDAO personDAO = new PersonDAO();

    @Test
    void testCreateHappyPath() {
        // given
        Person expectedPerson = new Person();
        expectedPerson.setAge(30);
        expectedPerson.setName("Sue");
        expectedPerson.setSurname("Smith");
        expectedPerson.setGender(Gender.FEMALE);

        // when
        personDAO.create(expectedPerson);

        // then
        Long expectedId = expectedPerson.getId();
        Person actualPerson = personDAO.findById(expectedId);

        Assertions.assertNotNull(actualPerson);
        Assertions.assertEquals(expectedPerson.getId(), actualPerson.getId());
        Assertions.assertEquals(expectedPerson.getAge(), actualPerson.getAge());
        Assertions.assertEquals(expectedPerson.getName(), actualPerson.getName());
        Assertions.assertEquals(expectedPerson.getGender(), actualPerson.getGender());
        Assertions.assertEquals(expectedPerson.getSurname(), actualPerson.getSurname());
    }

    @Test
    void testFindByIdPersonExists() {
        // given
        Person expectedPerson = new Person();
        expectedPerson.setAge(30);
        expectedPerson.setName("Sue");
        expectedPerson.setSurname("Smith");
        expectedPerson.setGender(Gender.FEMALE);

        personDAO.create(expectedPerson);
        Long expectedId = expectedPerson.getId();

        // when
        Person actualPerson = personDAO.findById(expectedId);

        // then
        Assertions.assertNotNull(actualPerson);
        Assertions.assertEquals(expectedPerson.getId(), actualPerson.getId());
        Assertions.assertEquals(expectedPerson.getAge(), actualPerson.getAge());
        Assertions.assertEquals(expectedPerson.getName(), actualPerson.getName());
        Assertions.assertEquals(expectedPerson.getGender(), actualPerson.getGender());
        Assertions.assertEquals(expectedPerson.getSurname(), actualPerson.getSurname());
    }

    @Test
    void testFindByIdPersonNotExists() {
        // given
        Long notExistingId = -1L;

        // when
        Person actualPerson = personDAO.findById(notExistingId);

        // then
        Assertions.assertNull(actualPerson);
    }
}
