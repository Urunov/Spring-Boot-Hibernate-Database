package com.urunov.repository;

import com.urunov.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is Graphql-Unittest
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookRepository {

    @Autowired
    BookRepository bookRepository;

    @Test
    public Iterable<Book> findAll() {
      return bookRepository.findAll();
    }




}
