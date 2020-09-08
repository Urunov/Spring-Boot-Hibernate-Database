package com.urunov.resolver;

import graphql.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is Graphql-Unittest
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QueryTest {

    @Autowired
    Query query;

    @Test
    public void findAllAuthors(){
        Assert.assertNotNull(query.findAllAuthors());
    }

    @Test
    public void countAuthor(){
        Assert.assertNotNull(query.countAuthors());
    }

    @Test
    public void findAllBooks(){
        Assert.assertNotNull(query.findAllBooks());
    }

    @Test
    public void countBook(){
        Assert.assertNotNull(query.countBooks());
    }

}
