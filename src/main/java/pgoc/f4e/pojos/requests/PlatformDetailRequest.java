package pgoc.f4e.pojos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"courseId","name","imageUrl","courseUrl","enable"})
public class PlatformDetailRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("courseUrl")
    private String courseUrl;

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("courseId")
    private String courseId;
}
