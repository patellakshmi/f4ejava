package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pgoc.f4e.pojos.requests.SliderImageRequest;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="slider_image")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SliderImage {
    @Id
    @Column(unique=true, name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="rank")
    private Long rank;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    public SliderImage(SliderImageRequest sliderImageRequest){
        this.name = sliderImageRequest.getName();
        this.description = sliderImageRequest.getDescription();
        this.imageUrl = sliderImageRequest.getImageUrl();
        this.rank = sliderImageRequest.getRank();
        this.enable = sliderImageRequest.isEnable();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
