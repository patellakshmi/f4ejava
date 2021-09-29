package pgoc.f4e.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pgoc.f4e.models.SliderImage;

import java.util.List;

@Repository
public interface SliderImageRepository extends JpaRepository<SliderImage,Long> {
    @Query("SELECT SI FROM SliderImage AS SI")
    List<SliderImage> getAllSliders();

    @Query("SELECT SI FROM SliderImage AS SI WHERE SI.imageUrl = ?1")
    SliderImage getByImageUrl(String url);
}
