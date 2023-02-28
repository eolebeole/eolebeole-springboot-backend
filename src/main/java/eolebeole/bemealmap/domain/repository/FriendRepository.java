package eolebeole.bemealmap.domain.repository;

import eolebeole.bemealmap.domain.entity.Friend;
import eolebeole.bemealmap.domain.entity.FriendId;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

// 기본키 타입 FriendId
@Repository
public interface FriendRepository extends JpaRepository<Friend, FriendId> {
}
