package spring.todo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * @Created 26 / 05 / 2020 - 11:10 AM
 * @project SpringToDo
 * @Author Hamdamboy
 */
@Entity
@Table(name="todosup")
public class Todo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min =3, max=50)
    @NotBlank
    private String name;

    @NotBlank
    @Size(min=3, max=150)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    private boolean finished;



    public Todo(){
        super();
        // Todo Auto-generated constructor stub
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Todo(String name, String description, Date dateCreate, boolean finished){
        super();

        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate;
        this.finished = finished;
    }

    @Override
    public String toString() {
        return
                "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreate=" + dateCreate +
                ", finished=" + finished +
                '}';
    }
}
