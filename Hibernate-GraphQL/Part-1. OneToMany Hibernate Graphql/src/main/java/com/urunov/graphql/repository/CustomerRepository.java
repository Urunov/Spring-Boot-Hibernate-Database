package com.urunov.graphql.repository;

import com.urunov.graphql.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: apple
 * @created on 07/09/2020
 * @Project is OnetoMany
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
