package pgoc.f4e.pojos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonPropertyOrder({"id","courseId","name","description","streamDtd","year","enable","subjectParts"})
public class SubjectRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("courseId")
    private String courseId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("streamStd")
    private String streamStd;

    @JsonProperty("year")
    private Long year;

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("subjectParts")
    private Set<SubjectPartRequest> subjectParts;
}
