package pgoc.f4e.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="potential_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PotentialUser {

    @Id
    @Column(unique=true, name="user_id")
    private String userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="mobile")
    private String mobile;

    @Column(name="password")
    private String password;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    public PotentialUser(String userId, String userName, String password){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.enable = true;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public PotentialUser(String userId, String password){
        this.userId = userId;
        this.password = password;
        this.enable = true;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }


}
