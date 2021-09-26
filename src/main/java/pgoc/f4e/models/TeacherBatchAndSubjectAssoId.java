package pgoc.f4e.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TeacherBatchAndSubjectAssoId implements Serializable {

    private String teacherId;
    private String batchId;
    private String subjectPartId;

    public TeacherBatchAndSubjectAssoId(String teacherId, String batchId, String subjectPartId){
        this.teacherId = teacherId;
        this.batchId = batchId;
        this.subjectPartId = subjectPartId;
    }
}
