package com.urunov.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private int lid;

    private String lname;

    public int getLid() {
        return lid;
    }

    public Laptop setLid(int lid) {
        this.lid = lid;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public Laptop setLname(String lname) {
        this.lname = lname;
        return this;
    }
}
