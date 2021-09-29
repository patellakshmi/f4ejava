package pgoc.f4e.pojos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import javax.persistence.Column;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonPropertyOrder({"name","description","imageUrl","rank","enable"})
public class SliderImageRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("rank")
    private Long rank;

    @JsonProperty("enable")
    private boolean enable;
}
