package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pgoc.f4e.models.PlatformDetail;

public interface PlatformDetailRepository extends JpaRepository<PlatformDetail, Long> {

    @Query("Select PD from PlatformDetail As PD where PD.name = ?1 AND PD.courseId =?2")
    PlatformDetail getByName(String name, String courseId);
}
