package orm.logic.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @Author: apple
 * @created on 29/07/2020
 * @Project is SpringORM
 */

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Locations> locations;
}
