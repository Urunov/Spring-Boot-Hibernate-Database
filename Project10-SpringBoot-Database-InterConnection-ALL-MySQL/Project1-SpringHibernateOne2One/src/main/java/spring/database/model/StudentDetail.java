package spring.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Created 08 / 06 / 2020 - 10:24 AM
 * @project SpringHibernateOne2One
 * @Author Hamdamboy
 */

@Entity
@Table(name = "student_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetail {

    @Column(name = "age")
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, length=25)
    private String email;

    @OneToOne(mappedBy = "studentDetail")
    private Student student;

    public StudentDetail(Integer age, String email){
        this.age = age;
        this.email = email;
    }
}
