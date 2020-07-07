package spring.country.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * @Created 12 / 06 / 2020 - 5:13 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */

@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthdate;

    @NotNull
    private String country;

    @NotNull
    private String address;

    @NotNull
    private Boolean marriage;

    @NotNull
    private String nationality;

    @NotNull
    private String education;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getMarriage() {
        return marriage;
    }

    public void setMarriage(Boolean marriage) {
        this.marriage = marriage;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//
////    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(
//                    name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//
//    private Collection<User> users;

    public People() {
    }




}
