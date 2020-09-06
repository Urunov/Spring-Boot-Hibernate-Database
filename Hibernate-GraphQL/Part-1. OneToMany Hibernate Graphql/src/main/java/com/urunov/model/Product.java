package com.urunov.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: apple
 * @created on 06/09/2020
 * @Project is GraphQL-OneToMany
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    private Integer pid;

    private String productName;
    private int qty;
    private int price;

}
