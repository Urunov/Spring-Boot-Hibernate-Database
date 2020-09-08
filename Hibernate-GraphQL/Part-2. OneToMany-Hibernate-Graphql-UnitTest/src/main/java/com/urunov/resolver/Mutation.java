package com.urunov.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.urunov.exception.BookNotFoundException;
import com.urunov.model.Author;
import com.urunov.model.Book;
import com.urunov.repository.AuthorRepository;
import com.urunov.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is Graphql-Unittest
 */
@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRespository;

    public Author newAuthor(String firstName, String lastName){
        Author author = new Author(firstName, lastName);
        authorRepository.save(author);
        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId){
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);
        bookRespository.save(book);
        return book;
    }

    public boolean deleteBook(Long id){
        bookRespository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRespository.findById(id).orElseThrow(
                ()->new BookNotFoundException("The book to be updated was not found", id));
        book.setPageCount(pageCount);
        bookRespository.save(book);
        return book;
    }


}
