package com.urunov.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: apple
 * @created on 06/09/2020
 * @Project is GraphQL-OneToMany
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String email;
    private String gender;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk", referencedColumnName = "id")
    private List<Product> products;





}
