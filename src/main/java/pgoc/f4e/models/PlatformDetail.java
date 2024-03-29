package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pgoc.f4e.pojos.requests.PlatformDetailRequest;

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
    private String imageUrl;

    @Column(name="course_url")
    private String courseUrl;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @Column(name="course_id")
    private String courseId;

    public PlatformDetail(PlatformDetailRequest platformDetailRequest){
        this.name = platformDetailRequest.getName();
        this.imageUrl = platformDetailRequest.getImageUrl();
        this.courseUrl = platformDetailRequest.getCourseUrl();
        this.enable = platformDetailRequest.isEnable();
        this.courseId = platformDetailRequest.getCourseId();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
