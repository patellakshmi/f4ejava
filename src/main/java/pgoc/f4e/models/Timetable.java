package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="timetable")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Timetable {

    @Id
    @Column(unique=true, name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="week_num")
    private Long weekNum;

    @Column(name="batch_id")
    private String batchId;

    @Column(name="month")
    private String month;

    @Column(name="day_of_month")
    private String dayOfMonth;

    /**
     * combo-timeslot
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sunday", referencedColumnName = "id")
    private ComboTimeslot sunday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monday", referencedColumnName = "id")
    private ComboTimeslot monday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tuesday", referencedColumnName = "id")
    private ComboTimeslot tuesday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wednesday", referencedColumnName = "id")
    private ComboTimeslot wednesday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thursday", referencedColumnName = "id")
    private ComboTimeslot thursday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "friday", referencedColumnName = "id")
    private ComboTimeslot friday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "saturday", referencedColumnName = "id")
    private ComboTimeslot saturday;

    /**
     * end of combo-Timeslot
     */

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

}
