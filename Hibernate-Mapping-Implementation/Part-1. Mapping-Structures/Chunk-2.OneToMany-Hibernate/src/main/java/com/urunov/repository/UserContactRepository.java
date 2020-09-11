package com.urunov.repository;

import com.urunov.model.UserContact;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 11/09/2020
 * @Project is Hibernate
 */

public interface UserContactRepository  extends JpaRepository<UserContact, Integer> {
}
