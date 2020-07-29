package com.thymeleaf.demo.service.impl;

import com.thymeleaf.demo.model.Contact;
import com.thymeleaf.demo.model.Person;
import com.thymeleaf.demo.repository.PersonRepository;
import com.thymeleaf.demo.service.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson() {
        return new Person();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void addContact(Person person) {
        person.getContactList().add(new Contact());
    }

    @Override
    public void removeContact(Person person, Integer contactIndex) {
        person.getContactList().remove(contactIndex.intValue());
    }

	@Override
	public List<Person> findAllPersons() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}
}
