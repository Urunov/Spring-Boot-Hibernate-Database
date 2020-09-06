package com.urunov.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@Data
public class Product {

    @Id
    private int pid;
    private String productName;
    private int qty;
    private int price;

    @ManyToOne
    @JoinColumn(name = "cuspro_fk", referencedColumnName = "id")
    private Customer customer;

}
