package com.urunov.graphql.repository;

import com.urunov.graphql.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 07/09/2020
 * @Project is OnetoMany
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
