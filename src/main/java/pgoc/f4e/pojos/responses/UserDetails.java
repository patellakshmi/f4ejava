package pgoc.f4e.pojos.responses;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetails {
    private Long id;
    private String name;
    private String address;
}
