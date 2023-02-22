package eolebeole.bemealmap.domain.repository;

import eolebeole.bemealmap.domain.entity.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgRepository extends JpaRepository<Img, Integer> {
}
