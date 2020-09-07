package com.urunov.graphql.repository;

import com.urunov.graphql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 07/09/2020
 * @Project is OnetoMany
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
