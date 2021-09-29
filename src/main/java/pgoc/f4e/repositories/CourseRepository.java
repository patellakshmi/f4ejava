package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pgoc.f4e.models.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    @Query("SELECT C.id from Course as C")
    List<String> getAllId();

    @Query("SELECT C from Course as C")
    List<Course> getAll();

}
