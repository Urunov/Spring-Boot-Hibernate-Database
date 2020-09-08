package com.urunov.repository;

import com.urunov.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is Graphql-Unittest
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    default Author findOneAuthor(Long id){
        return findById(id).orElse(null);
    }
}
