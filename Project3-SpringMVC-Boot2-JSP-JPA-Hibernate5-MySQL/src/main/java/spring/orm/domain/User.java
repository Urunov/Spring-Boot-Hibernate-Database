package spring.orm.domain;

import javax.persistence.*;

/**
 * @Created 25 / 05 / 2020 - 2:45 PM
 * @project SpringHibernateMySQL
 * @Author Hamdamboy
 */
@Entity
@Table(name = "userHibernate")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  String name;
    private  String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(){}

    public User(String name, String address){
        this.name = name;
        this.address = address;
    }

     public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
