package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="combo_timeslot")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComboTimeslot {

    @Id
    @Column(unique=true, name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="batch_id")
    private String batchId;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="combo_timeslot_id")
    private Set<Timeslot> timeslots;
}
