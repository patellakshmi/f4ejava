package pgoc.f4e.pojos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonPropertyOrder({"name","imageUrl","enable","createdAt","updatedAt"})
public class CoursePlatformResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("imageUrl")
    private Double imageUrl;

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("createdAt")
    private Timestamp createdAt;

    @JsonProperty("updatedAt")
    private Timestamp updatedAt;

}
