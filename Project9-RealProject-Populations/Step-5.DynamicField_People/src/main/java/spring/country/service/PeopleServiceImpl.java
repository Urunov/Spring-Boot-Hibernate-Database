package spring.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.country.model.Contact;
import spring.country.model.People;
import spring.country.repository.PeopleDAO;


import java.util.List;
import java.util.Optional;

/**
 * @Created 15 / 06 / 2020 - 5:59 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */
@Service
public class PeopleServiceImpl implements PeopleService{

    @Autowired
    private PeopleDAO peopleDAO;

    @Override
    public List<People> getAllPeople() {
        return peopleDAO.findAll();
    }

    @Override
    public People save(People people) {
      return this.peopleDAO.save(people);
    }

    @Override
    public void addContact(People people) {
        people.getContactList().add(new Contact());
    }

    @Override
    public People getPeopleId(long id) {
        Optional<People> optional = peopleDAO.findById(id);
        People people = null;
        if(optional.isPresent()) {
            people = optional.get();
        } else{
            throw new RuntimeException("People not found for id: "+ id);
        }

        return people;
    }

    @Override
    public void deletePeopleById(long id) {
        this.peopleDAO.deleteById(id);
    }

    @Override
    public People createPeople() {
        return new People();
    }

    @Override
    public void removeContact(People people, Integer contactIndex) {
        people.getContactList().remove(contactIndex.intValue());
    }

    @Override
    public Page<People> findPaginated(int pageNo, int pageSize, String sortField, String sortDierection) {

        Sort sort = sortDierection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return this.peopleDAO.findAll(pageable);
    }
}
