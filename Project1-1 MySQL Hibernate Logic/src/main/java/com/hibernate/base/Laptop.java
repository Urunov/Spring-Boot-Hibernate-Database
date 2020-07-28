package com.hibernate.base;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity

public class Laptop {

    @Id
    private int LId;

    private String name;


    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + LId +
                ", name='" + name + '\'' +
                '}';
    }

    public int getlId() {
        return LId;
    }

    public void setlId(int lId) {
        this.LId = lId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    private Student student;
}
