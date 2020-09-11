package com.urunov.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: apple
 * @created on 11/09/2020
 * @Project is Hibernate

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private Integer id;

    private Integer phoneNo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public UserContact setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserContact setUser(User user) {
        this.user = user;
        return this;
    }
}

