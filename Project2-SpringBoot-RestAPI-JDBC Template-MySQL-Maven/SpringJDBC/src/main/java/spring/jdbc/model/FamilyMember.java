package spring.jdbc.model;

/**
 * @Created 14 / 03 / 2020 - 9:33 PM
 * @project SpringJDBC
 * @Author Hamdamboy
 */
public class FamilyMember {


    //
    private int id;
    private String firstname;
    private String lastname;
    private int age;


    public FamilyMember() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
