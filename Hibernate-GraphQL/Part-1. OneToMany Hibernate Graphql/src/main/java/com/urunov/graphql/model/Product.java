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

    public Product(String name, String slug, String unit, Float price, Float salePrice, String description, String type, String image ){
        this.productName = name;
        this.slug = slug;
        this.price = price;
        this.salePrice = salePrice;
        this.description = description;
        this.type  = type;
        this.image = image;
    }


    @ManyToOne
    @JoinColumn(name = "cp_fk_id", nullable = false, updatable = false)
    private Customer customer;

}
