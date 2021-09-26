package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pgoc.f4e.models.Batch;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch,String> {
    @Query("SELECT B from Batch as B where B.courseId =?1")
    List<Batch> findByCourseId(String courseId);
}
