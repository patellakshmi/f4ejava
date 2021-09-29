package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pgoc.f4e.pojos.requests.SubjectPartRequest;
import pgoc.f4e.pojos.requests.SubjectRequest;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @Column(unique=true, name="id")
    private String id;

    @Column(name="course_id")
    private String course_id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="stream_std")
    private String streamStd;

    @Column(name="year")
    private Long year;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="sub_id")
    private Set<SubjectPart> subjectParts;

    public Subject(SubjectRequest subjectRequest){
        this.id = subjectRequest.getCourseId()+subjectRequest.getId();
        this.course_id = subjectRequest.getCourseId();
        this.name = subjectRequest.getName();
        this.streamStd = subjectRequest.getStreamStd();
        this.year = subjectRequest.getYear();
        this.description = subjectRequest.getDescription();
        this.enable = subjectRequest.isEnable();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        subjectParts = new HashSet<>();
        for(SubjectPartRequest subjectPartRequest: subjectRequest.getSubjectParts()){
                SubjectPart subjectPart = new SubjectPart(this.id, subjectPartRequest);
                subjectParts.add(subjectPart);
        }
    }

}

