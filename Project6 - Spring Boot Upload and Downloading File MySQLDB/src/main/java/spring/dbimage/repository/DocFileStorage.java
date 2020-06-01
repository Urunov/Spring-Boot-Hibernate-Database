package spring.dbimage.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.dbimage.model.FileDocs;

/**
 * @Created 01 / 06 / 2020 - 2:02 PM
 * @project SpringDBImage
 * @Author Hamdamboy
 */
@Repository
public interface DocFileStorage extends JpaRepository<FileDocs,Integer> {

}
