package pgoc.f4e.pojos.requests;

import lombok.Builder;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@Builder
public class PlatformDetailRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("image_url")
    private Double imageUrl;

    @JsonProperty("course_url")
    private Double courseUrl;

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("created_at")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    @JsonProperty("course_id")
    private String courseId;
}
