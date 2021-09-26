package pgoc.f4e.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="timeslot")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Timeslot {

    @Id
    @Column(unique=true, name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="start_at")
    private String start_at;

    @Column(name="end_at")
    private String end_at;

    @Column(name="subject_part_id")
    private String subjectPartId;

    @Column(name="combo_timeslot_id")
    private Long comboTimeSlotId;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;
}
