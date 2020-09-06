package com.urunov.controller;

import com.urunov.dto.OrderRequest;
import com.urunov.dto.OrderResponse;
import com.urunov.model.Customer;
import com.urunov.model.Product;
import com.urunov.repositories.CustomerRepository;
import com.urunov.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: apple
 * @created on 03/09/2020
 * @Project is OneToMany
 */

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
       return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJonInformation(){
       return customerRepository.getJoinInformation();
    }

    @GetMapping("/getProduct")
    public List<Product> justResponse(){
        return productRepository.findAll();
    }
}
