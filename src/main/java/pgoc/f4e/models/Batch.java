package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Batch {

    @Id
    @Column(unique=true, name="id")
    private String id;

    @Column(name="course_id")
    private String courseId;

    @Column(name="name")
    private String name;

    @Column(name="mode")
    private String mode;

    @Column(name="address")
    private String address;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="longitude")
    private Double longitude;

    @Column(name="duration")
    private Long duration;

    @Column(name="duration_unit")
    private String durationUnit;

    @Column(name="started_at")
    private Date startedAt;

    @Column(name="status")
    private String status;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="batch_id")
    private Set<Timetable> timetables;

}
