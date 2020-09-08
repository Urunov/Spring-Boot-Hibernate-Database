package com.urunov;

import com.urunov.model.Author;
import com.urunov.model.Book;
import com.urunov.repository.AuthorRepository;
import com.urunov.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


@SpringBootApplication
//@Import(GraphQLErrorHandlerConfig.class)
public class GraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlApplication.class, args);
    }
    @Bean

    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository){

        return (args) -> {
            Author author = new Author("elon", "kwon");
            authorRepository.save(author);
            bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));

        };
    }
}
