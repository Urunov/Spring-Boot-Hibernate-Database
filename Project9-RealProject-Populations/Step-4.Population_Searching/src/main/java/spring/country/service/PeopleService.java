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

    void save(People people);

    People getPeopleId(int id);

    void deletePeopleById(int id);

    Page<People> findPaginated(int pageNo, int pageSize, String sortField, String sortDierection);
}
