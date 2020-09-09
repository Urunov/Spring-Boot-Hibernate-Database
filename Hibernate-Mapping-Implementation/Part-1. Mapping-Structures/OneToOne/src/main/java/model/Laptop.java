package model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: apple
 * @created on 09/09/2020
 * @Project is Hibernate-Implementation
 */

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Laptop {

    @Id
    private int lid;

    private String name;

    public Laptop() {
    }
}

