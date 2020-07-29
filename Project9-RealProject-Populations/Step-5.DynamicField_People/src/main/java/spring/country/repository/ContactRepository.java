package spring.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.country.model.Contact;

import java.util.List;

/**
 * @Created 09 / 07 / 2020 - 11:34 AM
 * @project SpringCountryDBThymelead
 * @Author Hamdamboy
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

//    @Query("SELECT p FROM Contact p WHERE CONCAT(p.contactName, ' ', p.contactType, ' ', p.id) LIKE %?1%")
//    List<Contact> search(String keyword);
//    List<Contact> getContactByPeopleId(Long peopleId);


    @Query(value="SELECT * FROM Contact WHERE person_id=:personid", nativeQuery=true)
    List<Contact> getContactsByPersonId(Long personid);
}
