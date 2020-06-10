package spring.budget.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

/**
 * @Created 10 / 06 / 2020 - 10:30 AM
 * @project FamilyBudgetOne2Many
 * @Author Hamdamboy
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties (
        value = {"createAt", "updateAt"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt){

        this.createAt = createAt;
    }

    public void setUpdatedAt(Date updatedAt){
        this.updatedAt = updatedAt;
    }

}

/***
 *  -  @Lob annotation - specifies that the database should store the property as Large Object.
 *  -  @Column annotation - defines the column type for the property.
 *  -
 * */