package spring.budget.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.budget.model.Comment;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @Created 10 / 06 / 2020 - 10:30 AM
 * @project FamilyBudgetOne2Many
 * @Author Hamdamboy
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByPostId(Long postId, Pageable pageable);
    Optional<Comment> findByIdAndPostId(Long id, Long postId);
}
