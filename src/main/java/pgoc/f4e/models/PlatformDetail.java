package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="platform_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlatformDetail {

    @Id
    @Column(unique=true, name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="image_url")
    private Double imageUrl;

    @Column(name="course_url")
    private Double courseUrl;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @Column(name="course_id")
    private String courseId;

}
