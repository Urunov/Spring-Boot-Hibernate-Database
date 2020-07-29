package com.thymeleaf.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thymeleaf.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{
	
	List<Person> findByFirstnameIgnoreCaseContaining(String firstname);
}
