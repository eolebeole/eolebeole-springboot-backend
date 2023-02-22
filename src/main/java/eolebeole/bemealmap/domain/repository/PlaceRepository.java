package eolebeole.bemealmap.domain.repository;

import eolebeole.bemealmap.domain.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
