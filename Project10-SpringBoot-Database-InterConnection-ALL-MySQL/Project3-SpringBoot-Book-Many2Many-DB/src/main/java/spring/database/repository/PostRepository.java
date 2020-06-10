package spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.database.model.Post;

/**
 * @Created 10 / 06 / 2020 - 4:34 PM
 * @project SpringDatabaseMany2Many
 * @Author Hamdamboy
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
