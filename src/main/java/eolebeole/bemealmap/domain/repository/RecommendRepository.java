package eolebeole.bemealmap.domain.repository;

import eolebeole.bemealmap.domain.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Integer> {
}
