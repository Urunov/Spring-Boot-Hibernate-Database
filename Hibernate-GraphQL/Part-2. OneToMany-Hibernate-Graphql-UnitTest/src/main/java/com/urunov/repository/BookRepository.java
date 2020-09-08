package com.urunov.repository;

import com.urunov.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is Graphql-Unittest
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


}
