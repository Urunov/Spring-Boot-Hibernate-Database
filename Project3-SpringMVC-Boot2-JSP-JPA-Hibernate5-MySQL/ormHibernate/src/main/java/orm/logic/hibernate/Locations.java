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
@Table(name = "locations")
public class Locations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String location;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Users user;
}
