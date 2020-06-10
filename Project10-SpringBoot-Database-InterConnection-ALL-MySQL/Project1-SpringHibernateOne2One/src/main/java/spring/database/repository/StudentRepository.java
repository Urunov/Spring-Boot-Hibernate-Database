package spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.database.model.Student;

/**
 * @Created 08 / 06 / 2020 - 10:37 AM
 * @project SpringHibernateOne2One
 * @Author Hamdamboy
 */

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);
}
