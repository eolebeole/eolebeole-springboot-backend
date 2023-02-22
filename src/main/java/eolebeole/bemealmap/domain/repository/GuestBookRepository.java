package eolebeole.bemealmap.domain.repository;

import eolebeole.bemealmap.domain.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestBookRepository extends JpaRepository<GuestBook, Integer> {
}
