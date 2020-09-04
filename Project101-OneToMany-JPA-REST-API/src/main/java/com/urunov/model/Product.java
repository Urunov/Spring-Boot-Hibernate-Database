package com.urunov.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
