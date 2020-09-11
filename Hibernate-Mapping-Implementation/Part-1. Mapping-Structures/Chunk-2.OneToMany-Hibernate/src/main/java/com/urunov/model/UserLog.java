package com.urunov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: apple
 * @created on 11/09/2020
 * @Project is Hibernate
 */
@Data
@ToString
@Entity
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_id")
    private Integer id;

    private String log;

    // Mapping variable.
    @Column(name = "user_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public UserLog setLog(String log) {
        this.log = log;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserLog setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
//https://www.youtube.com/watch?v=1SIkBduGXeE&ab_channel=TechPrimers