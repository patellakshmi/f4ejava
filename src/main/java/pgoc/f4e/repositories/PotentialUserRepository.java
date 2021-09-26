package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pgoc.f4e.models.PotentialUser;

@Repository
public interface PotentialUserRepository extends JpaRepository<PotentialUser, String> {
    @Query("select u from PotentialUser u where u.userName = ?1 or u.userId = ?1 or u.email = ?1 or mobile = ?1")
    PotentialUser findByAnyOfUniqueField(String value);
}
