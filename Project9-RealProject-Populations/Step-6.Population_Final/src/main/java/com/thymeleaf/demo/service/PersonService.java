package com.thymeleaf.demo.service;

import java.util.List;

import com.thymeleaf.demo.model.Person;

public interface PersonService {
    Person createPerson();
    Person savePerson(Person person);
    void addContact(Person person);
    void removeContact(Person person, Integer contactIndex);
    List<Person> findAllPersons();
}
