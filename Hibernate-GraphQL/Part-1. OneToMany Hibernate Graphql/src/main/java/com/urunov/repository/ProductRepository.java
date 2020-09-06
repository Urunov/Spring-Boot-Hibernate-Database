package com.urunov.repository;

import com.urunov.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 06/09/2020
 * @Project is GraphQL-OneToMany
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
