package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;
import pgoc.f4e.pojos.requests.ObjectiveRequest;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="objective")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Objective {

    @Id
    @Column(unique=true, name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("objective")
    private String objective;

    @JsonProperty("enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    public Objective(ObjectiveRequest objectiveRequest){
        this.name = objectiveRequest.getName();
        this.objective = objectiveRequest.getObjective();
        this.enable = objectiveRequest.isEnable();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
