package com.urunov.model;

import lombok.*;

import javax.persistence.*;

/**
 * @Author: apple
 * @created on 10/09/2020
 * @Project is Mapping-One2One
 */

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rollno;

    private String name;

    private int mark;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rollno_id", referencedColumnName = "lid")
    private Laptop laptop;



    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getMark() {
        return mark;
    }

    public Student setMark(int mark) {
        this.mark = mark;
        return this;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public Student setLaptop(Laptop laptop) {
        this.laptop = laptop;
        return this;
    }
}
