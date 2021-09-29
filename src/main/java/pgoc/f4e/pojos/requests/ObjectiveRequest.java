package pgoc.f4e.pojos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonPropertyOrder({"name","objective","enable"})
public class ObjectiveRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("objective")
    private String objective;

    @JsonProperty("enable")
    private boolean enable;
}
