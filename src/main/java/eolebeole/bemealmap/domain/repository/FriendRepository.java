package eolebeole.bemealmap.domain.repository;

import eolebeole.bemealmap.domain.entity.Friend;
import eolebeole.bemealmap.domain.entity.FriendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 기본키 타입 FriendId
@Repository
public interface FriendRepository extends JpaRepository<Friend, FriendId> {
}
