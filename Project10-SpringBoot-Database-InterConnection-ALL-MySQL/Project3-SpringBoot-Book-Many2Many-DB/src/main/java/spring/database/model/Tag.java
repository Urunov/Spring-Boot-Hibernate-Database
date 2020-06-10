package spring.database.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NaturalId;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Created 10 / 06 / 2020 - 4:34 PM
 * @project SpringDatabaseMany2Many
 * @Author Hamdamboy
 */

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @NaturalId
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
            },
    mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();

    public Tag(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Tag(String hibernate){}


}

