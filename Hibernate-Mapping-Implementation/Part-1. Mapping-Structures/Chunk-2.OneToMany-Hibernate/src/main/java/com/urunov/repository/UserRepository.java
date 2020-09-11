package com.urunov.repository;

import com.urunov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: apple
 * @created on 11/09/2020
 * @Project is Hibernate
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);
}
