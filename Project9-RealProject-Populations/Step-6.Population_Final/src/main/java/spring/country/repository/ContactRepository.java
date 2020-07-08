package spring.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.country.model.Contact;

import java.util.List;

/**
 * @Created 08 / 07 / 2020 - 2:01 PM
 * @project SpringCountryDBThymelead
 * @Author Hamdamboy
 */

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT * FROM Contact WHERE people_id=:peopleid", nativeQuery = true)
    List<Contact> getContactsByPersonId(Long personid);
}
