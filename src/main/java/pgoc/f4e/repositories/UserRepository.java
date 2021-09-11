package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pgoc.f4e.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);
}
