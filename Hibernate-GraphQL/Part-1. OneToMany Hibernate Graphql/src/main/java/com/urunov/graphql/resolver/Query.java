package com.urunov.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.urunov.graphql.model.Customer;
import com.urunov.graphql.model.Product;
import com.urunov.graphql.repository.CustomerRepository;
import com.urunov.graphql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 07/09/2020
 * @Project is OnetoMany
 */
@Component
public class Query implements GraphQLQueryResolver {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    @Autowired
    public Query(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public Iterable<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Iterable<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public int countCustomer(){
        return (int) customerRepository.count();
    }

    public int countProducts(){
        return (int) productRepository.count();
    }



}
