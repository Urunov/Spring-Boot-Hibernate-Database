package spring.people.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.people.model.People;
import spring.people.repository.PeopleDAO;

import java.util.List;

/**
 * @Created 15 / 06 / 2020 - 5:59 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */
@Service
public class PeopleService {

    @Autowired
    private PeopleDAO peopleDAO;

    public List<People> listAll(String keyword) {
        if(keyword !=null){
            return peopleDAO.search(keyword);
        }
        return peopleDAO.findAll();
    }

    public void save(People people) {
        peopleDAO.save(people);
    }

    public People get(Integer id) {
        return peopleDAO.findById(id).get();
    }

    public void delete(Integer id){
        peopleDAO.deleteById(id);
    }

    public void saveAndFlush(People people) {
        peopleDAO.save(people);
    }
}
