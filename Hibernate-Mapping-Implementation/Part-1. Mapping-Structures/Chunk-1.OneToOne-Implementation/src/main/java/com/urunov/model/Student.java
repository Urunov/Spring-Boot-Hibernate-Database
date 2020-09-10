package com.urunov.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @Author: apple
 * @created on 10/09/2020
 * @Project is Mapping-One2One
 */

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private int rollno;

    private String name;

    private int mark;

    @OneToOne
    private Laptop laptop;

}
