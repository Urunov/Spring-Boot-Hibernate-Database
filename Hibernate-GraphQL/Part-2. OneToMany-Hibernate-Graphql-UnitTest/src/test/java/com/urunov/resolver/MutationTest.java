package com.urunov.resolver;

import com.urunov.exception.BookNotFoundException;

import com.urunov.model.Author;
import com.urunov.model.Book;

import com.urunov.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

import static org.junit.Assert.assertThat;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is Graphql-Unittest
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MutationTest {

    @Autowired
    Mutation mutation;

    @Autowired
    BookRepository bookRepository;


    @Test
    public void newAuthor() {
        assertThat(mutation.newAuthor("star", "bucks"),
                is(instanceOf(Author.class)));
    }

    @Test
    public void newBook(){
        assertThat(mutation.newBook("booktest title", "09332323232", 434, (long)1),
                is(instanceOf(Book.class)));
    }

    @Test
    public void deleteBook() {
        assertThat(mutation.deleteBook((long) 2),
                is(true));
    }

    @Test
    public void updateBookPageCount() {
        assertThat(mutation.updateBookPageCount(340, (long) 2),
                is(instanceOf(Book.class)));
    }
    @Test(expected = BookNotFoundException.class)
    public void updateBookPageCountWithInvalidId(){
        mutation.updateBookPageCount(340, (long)10);
    }


}
