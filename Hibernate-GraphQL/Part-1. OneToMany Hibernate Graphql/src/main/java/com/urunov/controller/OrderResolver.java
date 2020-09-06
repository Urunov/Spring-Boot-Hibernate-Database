package com.urunov.controller;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.urunov.dto.OrderRequest;
import com.urunov.model.Customer;
import com.urunov.repository.CustomerRepository;
import com.urunov.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: apple
 * @created on 06/09/2020
 * @Project is GraphQL-OneToMany
 */

@Component
@RequiredArgsConstructor
public class OrderResolver implements GraphQLMutationResolver {


    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;



    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }


}
