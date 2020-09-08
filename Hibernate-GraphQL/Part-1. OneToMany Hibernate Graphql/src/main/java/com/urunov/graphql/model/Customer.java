package com.urunov.graphql.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: apple
 * @created on 07/09/2020
 * @Project is OnetoMany
 */
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer cid;
    private String customerName;
    private String image;
    private String email;
    private int totalOrder;
    private int totalOrderAmount;

    public Customer(String customerName, String image, String email, int totalOrder, int totalOrderAmount) {
        this.customerName = customerName;
        this.image = image;
        this.email = email;
        this.totalOrder = totalOrder;
        this.totalOrderAmount = totalOrderAmount;
    }

    public Customer(Integer id) {
    }
}
