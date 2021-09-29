package pgoc.f4e.pojos.responses;

import lombok.Builder;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.sql.Timestamp;

@Data
@Builder
@JsonPropertyOrder({"courseId","name","imageUrl","courseUrl","enable","createdAt","updatedAt"})
public class PlatformDetailResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("imageUrl")
    private Double imageUrl;

    @JsonProperty("courseUrl")
    private Double courseUrl;

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("createdAt")
    private Timestamp createdAt;

    @JsonProperty("updatedAt")
    private Timestamp updatedAt;

    @JsonProperty("courseId")
    private String courseId;
}
