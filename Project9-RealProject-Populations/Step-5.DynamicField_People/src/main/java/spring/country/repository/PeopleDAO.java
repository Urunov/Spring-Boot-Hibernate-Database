package spring.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.country.model.People;

import java.util.List;

/**
 * @Created 12 / 06 / 2020 - 5:13 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */

public interface PeopleDAO extends JpaRepository<People, Long> {


    @Query("SELECT p FROM People p WHERE CONCAT(p.firstName, ' ', p.birthdate, ' ', p.lastName, ' ', p.education, ' ', p.address, ' ', p.marriage) LIKE %?1%")
    List<People> search(String keyword);

    List<People> findByFirstNameIgnoreCaseContaining(String firstName);
}
