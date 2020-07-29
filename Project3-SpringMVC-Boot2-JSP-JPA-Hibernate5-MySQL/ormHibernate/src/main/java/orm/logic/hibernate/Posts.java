package orm.logic.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: apple
 * @created on 29/07/2020
 * @Project is SpringORM
 */
@Entity
@Table(name = "posts")
public class Posts implements Serializable {

    @Id
    private int id;
    private Date postDate;
    private String details;

    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;
}
