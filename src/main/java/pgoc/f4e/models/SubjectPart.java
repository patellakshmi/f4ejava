package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pgoc.f4e.pojos.requests.SubjectPartRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="subject_part")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectPart {

    @Id
    @Column(unique=true, name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="sub_id")
    private String subId;

    @Column(name="description")
    private String description;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    public SubjectPart(String subId,SubjectPartRequest subjectPartRequest){
        this.id = subId+subjectPartRequest.getId();
        this.subId = subId;
        this.name = subjectPartRequest.getName();
        this.enable = subjectPartRequest.isEnable();
        this.description = subjectPartRequest.getDescription();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
