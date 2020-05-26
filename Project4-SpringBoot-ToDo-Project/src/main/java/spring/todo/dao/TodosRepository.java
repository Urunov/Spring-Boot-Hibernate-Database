package spring.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.todo.model.Todo;

/**
 * @Created 26 / 05 / 2020 - 11:08 AM
 * @project SpringToDo
 * @Author Hamdamboy
 */
@Repository
public interface TodosRepository extends JpaRepository<Todo, Integer> {

}
