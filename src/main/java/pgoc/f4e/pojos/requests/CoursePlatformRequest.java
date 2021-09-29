package pgoc.f4e.pojos.requests;

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
@JsonPropertyOrder({"name","imageUrl","enable"})
public class CoursePlatformRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("imageUrl")
    private Double imageUrl;

    @JsonProperty("enable")
    private boolean enable;


}
