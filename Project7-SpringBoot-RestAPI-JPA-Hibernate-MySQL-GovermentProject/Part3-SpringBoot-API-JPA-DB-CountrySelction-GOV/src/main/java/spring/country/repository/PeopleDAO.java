package spring.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.people.model.People;

import java.util.List;

/**
 * @Created 12 / 06 / 2020 - 5:13 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */
@Repository
public interface PeopleDAO extends JpaRepository<People, Integer> {


    @Query("SELECT p FROM People p WHERE CONCAT(p.Name, ' ', p.Age, ' ', p.FamilyName, ' ', p.Education, ' ', p.Address, ' ', p.Marage) LIKE %?1%")
    List<People> search(String keyword);
}
