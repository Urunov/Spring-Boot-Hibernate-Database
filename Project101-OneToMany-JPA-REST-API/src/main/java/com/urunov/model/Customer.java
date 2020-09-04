package com.urunov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: apple
 * @created on 03/09/2020
 * @Project is OneToMany
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String email;
    private String gender;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cuspro_fk", referencedColumnName = "id")
    private List<Product> productList;
}
