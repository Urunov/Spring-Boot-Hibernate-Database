package com.urunov.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.urunov.model.Author;
import com.urunov.model.Book;
import com.urunov.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is Graphql-Unittest
 */
@Service
@Component
public class BookResolver implements GraphQLResolver<Book> {

    @Autowired
    AuthorRepository authorRepository;

    public Author getAuthor(Book book){
        return authorRepository.findOneAuthor(book.getAuthor().getId());
    }

}
