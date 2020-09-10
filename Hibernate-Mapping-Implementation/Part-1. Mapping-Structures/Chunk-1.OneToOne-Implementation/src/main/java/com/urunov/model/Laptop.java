package com.urunov.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: apple
 * @created on 10/09/2020
 * @Project is Mapping-One2One
 */

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Laptop {

    @Id
    private int lid;

    private String lname;


}
