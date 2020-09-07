package com.urunov.graphql.model;

import lombok.*;

import javax.persistence.*;

/**
 * @Author: apple
 * @created on 07/09/2020
 * @Project is OnetoMany
 */

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Product {

    @Id
    @GeneratedValue
    private Integer pid;
    private String productName;
    private String slug;
    private String unit;
    private Float price;
    private Float salePrice;
    private String description;
    private String type;
    private String image;

    @ManyToOne
    @JoinColumn(name = "cp_fk", nullable = false, updatable = false, referencedColumnName="pid")
    private Customer customer;

}
