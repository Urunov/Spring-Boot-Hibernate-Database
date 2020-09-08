package com.urunov.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.urunov.model.Author;
import com.urunov.model.Book;
import com.urunov.repository.AuthorRepository;
import com.urunov.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is Graphql-Unittest
 */
@Service
public class Query implements GraphQLQueryResolver {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public long countAuthors(){
        return authorRepository.count();
    }

    public Iterable<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public long countBooks(){
        return bookRepository.count();
    }
}
