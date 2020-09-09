package model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @Author: apple
 * @created on 09/09/2020
 * @Project is Hibernate-Implementation
 */
@Data
@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
public class Student {

    @Id
    private int rollno;
    private String name;
    private int mark;

    public Student() {
    }

   @OneToOne
   private Laptop laptop;


}
