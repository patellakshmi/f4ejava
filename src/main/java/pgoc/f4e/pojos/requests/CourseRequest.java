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
@JsonPropertyOrder({"id","name","fee","currency","off","off_keyword","streamStd","duration","durationUnit","mode"
,"imageUrl","description","benefit","enable"})
public class CourseRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("fee")
    private Double fee;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("off")
    private Double off;

    @JsonProperty("off_keyword")
    private String off_keyword;

    @JsonProperty("streamStd")
    private String streamStd;

    @JsonProperty("duration")
    private Long duration;

    @JsonProperty("durationUnit")
    private String durationUnit;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("description")
    private String description;

    @JsonProperty("benefit")
    private String benefit;

    @JsonProperty("enable")
    private boolean enable;
}
