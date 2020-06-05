package spring.crudadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.crudadmin.model.UserEvent;

import java.util.List;

/**
 * @Created 05 / 06 / 2020 - 10:36 AM
 * @project SpringCrudAdmin
 * @Author Hamdamboy
 */
@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

    List<UserEvent> findByName(String name);
    List<UserEvent> findByToken(String token);
    List<UserEvent>findByUserId(String userId);
}
