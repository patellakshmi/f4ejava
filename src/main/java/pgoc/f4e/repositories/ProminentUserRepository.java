package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pgoc.f4e.models.ProminentUser;

@Repository
public interface ProminentUserRepository extends JpaRepository<ProminentUser, String> {
    @Query("select u from ProminentUser u where u.userName = ?1 or u.userId = ?1 or u.email = ?1 or mobile = ?1")
    ProminentUser findByAnyOfUniqueField(String value);
}
