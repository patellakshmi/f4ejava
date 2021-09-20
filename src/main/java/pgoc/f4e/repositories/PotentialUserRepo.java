package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pgoc.f4e.models.PotentialUser;

@Repository
public interface PotentialUserRepo extends JpaRepository<PotentialUser, String> {
    @Query("select u from PotentialUser u where u.userId = ?1")
    PotentialUser findByAnyOfUniqueField(String value);
}
