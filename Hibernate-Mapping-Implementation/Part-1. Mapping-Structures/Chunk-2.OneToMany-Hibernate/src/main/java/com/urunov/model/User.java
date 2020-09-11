package com.urunov.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: apple
 * @created on 11/09/2020
 * @Project is Hibernate
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name")
    private String name;
    private Integer salary;
    private String teamName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<UserLog> userLogs;

    public List<UserLog> getUserLogs() {
        return userLogs;
    }

    public User setUserLogs(List<UserLog> userLogs) {
        this.userLogs = userLogs;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public User setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public User setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }
}
