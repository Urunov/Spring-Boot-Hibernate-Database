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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;

    private  String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_detail_id")

    private StudentDetail studentDetail;

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, StudentDetail studentDetail) {
        this.name = name;
        this.studentDetail = studentDetail;
    }
}
