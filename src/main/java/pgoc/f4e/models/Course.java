package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pgoc.f4e.pojos.requests.CourseRequest;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @Column(unique=true, name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="fee")
    private Double fee;

    @Column(name="currency")
    private String currency;

    @Column(name="off")
    private Double off;

    @Column(name="off_keyword")
    private String off_keyword;

    @Column(name="stream_std")
    private String streamStd;

    @Column(name="duration")
    private Long duration;

    @Column(name="duration_unit")
    private String durationUnit;

    @Column(name="mode")
    private String mode;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="description")
    private String description;

    @Column(name="benefit")
    private String benefit;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="course_id")
    private Set<PlatformDetail> platformDetails;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="course_id")
    private Set<Subject> subjects;


    public Course(CourseRequest courseRequest){
        this.id = courseRequest.getId();
        this.name = courseRequest.getName();
        this.fee = courseRequest.getFee();
        this.currency = courseRequest.getCurrency();
        this.off = courseRequest.getOff();
        this.off_keyword = courseRequest.getOff_keyword();
        this.streamStd = courseRequest.getStreamStd();
        this.duration = courseRequest.getDuration();
        this.durationUnit = courseRequest.getDurationUnit();
        this.mode = courseRequest.getMode();
        this.imageUrl = courseRequest.getImageUrl();
        this.description = courseRequest.getDescription();
        this.benefit = courseRequest.getBenefit();
        this.enable = courseRequest.isEnable();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());

    }

}


