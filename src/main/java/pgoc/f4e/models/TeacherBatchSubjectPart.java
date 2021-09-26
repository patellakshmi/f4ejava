package pgoc.f4e.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="teacher_batch_subject_part")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(TeacherBatchAndSubjectAssoId.class)
public class TeacherBatchSubjectPart {

    @Id
    @Column(name="teacher_id")
    private String teacherId;

    @Id
    @Column(name="batch_id")
    private String batchId;

    @Id
    @Column(name="subject_part_id")
    private String subjectPartId;

    @Column(name="enable")
    private boolean enable;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;
}
