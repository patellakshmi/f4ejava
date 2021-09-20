package pgoc.f4e.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="prominent_user")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProminentUser {

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


    public ProminentUser(String userId, String password){
        this.userId = userId;
        this.password = password;
        this.enable = true;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }


}
