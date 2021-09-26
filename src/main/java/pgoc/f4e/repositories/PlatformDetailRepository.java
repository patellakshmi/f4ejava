package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pgoc.f4e.models.PlatformDetail;

public interface PlatformDetailRepository extends JpaRepository<PlatformDetail, Long> {
}
