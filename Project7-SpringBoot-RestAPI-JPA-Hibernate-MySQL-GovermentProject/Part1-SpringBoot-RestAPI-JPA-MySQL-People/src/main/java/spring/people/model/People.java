package spring.people.model;

import com.sun.istack.NotNull;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * @Created 12 / 06 / 2020 - 5:13 PM
 * @project SpringBootPeople
 * @Author Hamdamboy
 */

@Entity
@Table(name = "peopleinfo")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String Name;
    @NotNull
    private String FamilyName;
    @NotNull
    private String Age;
    @NotNull
    private String Address;
    @NotNull
    private Boolean Marage;
    @NotNull
    private String Nationality;
    @NotNull
    private String Education;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Boolean getMarage() {
        return Marage;
    }

    public void setMarage(Boolean marage) {
        Marage = marage;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", FamilyName='" + FamilyName + '\'' +
                ", Age='" + Age + '\'' +
                ", Address='" + Address + '\'' +
                ", Marage=" + Marage +
                ", Nationality='" + Nationality + '\'' +
                ", Education='" + Education + '\'' +
                '}';
    }
}
