package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pgoc.f4e.models.Objective;

import java.util.List;

public interface ObjectiveRepository extends JpaRepository<Objective, Long> {
    @Query("SELECT C from Objective as C")
    List<Objective> getAll();
    @Query("SELECT C from Objective as C where C.name = ?1 AND C.objective = ?2")
    Objective getByNameAndObjective(String name, String objective);
}
