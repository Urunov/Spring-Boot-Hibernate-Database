package spring.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.people.model.People;

/**
 * @Created 12 / 06 / 2020 - 5:13 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */
@Repository
public interface PeopleDAO extends JpaRepository<People, Integer> {
}
