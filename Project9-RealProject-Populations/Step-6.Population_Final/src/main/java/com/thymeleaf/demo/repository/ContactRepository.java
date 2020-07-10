package com.thymeleaf.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thymeleaf.demo.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository <Contact, Long>{
	
	@Query(value="SELECT * FROM Contact WHERE person_id=:personid", nativeQuery=true)
	List<Contact> getContactsByPersonId(Long personid);
	
}
