package com.urunov.repositories;

import com.urunov.dto.OrderResponse;
import com.urunov.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: apple
 * @created on 03/09/2020
 * @Project is OneToMany
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT new  com.urunov.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.productList p")
    public List<OrderResponse> getJoinInformation();
}
