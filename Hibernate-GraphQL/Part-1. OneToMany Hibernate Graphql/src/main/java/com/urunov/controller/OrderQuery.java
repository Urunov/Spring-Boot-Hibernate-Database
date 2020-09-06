package com.urunov.controller;

/**
 * @Author: apple
 * @created on 06/09/2020
 * @Project is GraphQL-OneToMany
 */

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.urunov.dto.OrderResponse;
import com.urunov.model.Customer;
import com.urunov.model.Product;
import com.urunov.repository.CustomerRepository;
import com.urunov.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderQuery implements GraphQLQueryResolver {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }

    public List<Product> justResponse(){
        return productRepository.findAll();
    }
}
