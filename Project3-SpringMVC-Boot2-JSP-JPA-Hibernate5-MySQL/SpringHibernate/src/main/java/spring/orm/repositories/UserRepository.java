package spring.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.orm.domain.User;

/**
 * @Created 25 / 05 / 2020 - 2:45 PM
 * @project SpringHibernateMySQL
 * @Author Hamdamboy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
