package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pgoc.f4e.models.CoursePlatform;

public interface CoursePlatformRepository extends JpaRepository<CoursePlatform, Long> {
}
