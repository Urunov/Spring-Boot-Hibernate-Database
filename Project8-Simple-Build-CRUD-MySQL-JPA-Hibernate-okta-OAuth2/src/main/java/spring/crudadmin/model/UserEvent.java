package spring.crudadmin.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Created 05 / 06 / 2020 - 10:13 AM
 * @project SpringCrudAdmin
 * @Author Hamdamboy
 */
@Entity
@Table(name = "okta")
public class UserEvent {

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm'Z'");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Lob
    private String token;

    private String userId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tokenIssuedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastViewedAt;

    public static SimpleDateFormat getFormatter() {
        return formatter;
    }

    public static void setFormatter(SimpleDateFormat formatter) {
        UserEvent.formatter = formatter;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
    }

    public Date getTokenIssuedAt() {
        return tokenIssuedAt;
    }

    public void setTokenIssuedAt(Date tokenIssuedAt) {
        this.tokenIssuedAt = tokenIssuedAt;
    }

    public Date getLastViewedAt() {
        return lastViewedAt;
    }

    public void setLastViewedAt(Date lastViewedAt) {
        this.lastViewedAt = lastViewedAt;
    }

    public UserEvent(){}

    public UserEvent(String userId, String name, String token, Date loginAt, Date issuesAt){
        this.userId = userId;
        this.name = name;
        this.token = token;
        this.loginAt = loginAt;
        this.lastViewedAt = loginAt;
        this.tokenIssuedAt = issuesAt;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", userId='" + userId + '\'' +
                ", loginAt=" + loginAt +
                ", tokenIssuedAt=" + tokenIssuedAt +
                ", lastViewedAt=" + lastViewedAt +
                '}';
    }

    @Transient
    public String getLastViewedAtString(){
        return formatter.format(lastViewedAt);
    }

    @Transient
    public String getLoginAtString(){
        return formatter.format(loginAt);
    }
}
