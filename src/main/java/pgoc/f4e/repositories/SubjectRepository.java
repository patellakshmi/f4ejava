package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pgoc.f4e.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
