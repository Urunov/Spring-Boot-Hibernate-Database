package spring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.database.model.Post;
import spring.database.model.Tag;
import spring.database.repository.PostRepository;
import spring.database.repository.TagRepository;

@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;


    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Clean the tables

        postRepository.deleteAllInBatch();
        tagRepository.deleteAllInBatch();

        /// --------------------------

        // Create a Post

        Post post = new Post("Hibernate Many to Many Example with Spring Boot",
                "Learn how to map a many to many relationship using hibernate",
                "Entire Post content with Sample code");

        // Create two tags
        Tag tag1 = new Tag("Spring Boot");
        Tag tag2 = new Tag("Hibernate");

        // Add tag reference in the post
        post.getTags().add(tag1);
        post.getTags().add(tag2);

        // Add post references in the post

        post.getTags().add(tag1);
        post.getTags().add(tag2);

        // Add post reference in the tags
        tag1.getPosts().add(post);
        tag2.getPosts().add(post);

        postRepository.save(post);
    }
}
