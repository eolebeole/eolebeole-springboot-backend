package eolebeole.bemealmap.domain.repository;

import eolebeole.bemealmap.domain.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Long>{
    Optional<Token> findByValue(String tokenValue);
}
