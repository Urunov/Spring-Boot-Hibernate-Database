package spring.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.budget.model.Post;

/**
 * @Created 10 / 06 / 2020 - 10:30 AM
 * @project FamilyBudgetOne2Many
 * @Author Hamdamboy
 */
@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {
}
