package spring.country.service;

import org.springframework.data.domain.Page;
import spring.country.model.People;

import java.util.List;

/**
 * @Created 06 / 07 / 2020 - 12:20 PM
 * @project SpringCountryDBThymelead
 * @Author Hamdamboy
 */
public interface PeopleService{

    List<People> getAllPeople();

    People save(People people);

    void addContact(People people);

    People getPeopleId(long id);

    void deletePeopleById(long id);

    People createPeople();

    void removeContact(People people, Integer contactIndex);

    Page<People> findPaginated(int pageNo, int pageSize, String sortField, String sortDierection);
}
