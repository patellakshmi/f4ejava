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
@JsonPropertyOrder({"name","image_url","enable","create_at","updated_at"})
public class CoursePlatformResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("image_url")
    private Double imageUrl;

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("created_at")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    private Timestamp updatedAt;

}
