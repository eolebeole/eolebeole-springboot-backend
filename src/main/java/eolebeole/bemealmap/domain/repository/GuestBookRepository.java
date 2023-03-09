package eolebeole.bemealmap.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eolebeole.bemealmap.domain.entity.GuestBook;

@Repository
public interface GuestBookRepository extends JpaRepository<GuestBook, Integer> {
    List<GuestBook> findByUserIdOrderByCreatedAtDesc(int userId);
}
