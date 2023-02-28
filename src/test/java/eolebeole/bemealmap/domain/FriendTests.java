package eolebeole.bemealmap.domain;

import eolebeole.bemealmap.domain.entity.Friend;
import eolebeole.bemealmap.domain.friend.FriendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FriendTests {
    @Autowired
    private FriendService friendService;

    @Test
    void testRead() {
        int userId = 1;

        List<Friend> friends = friendService.getAllFriends(userId);
        friends.forEach(friend -> {
            System.out.println(friend);
            System.out.println(friend.getUser2());
        });

//        // 값 불러오기
//        Optional<Friend> friend1 = friendRepository.findById(friend.getUserId1());
//        Optional<Friend> friend2 = friendRepository.findById(friend.getUserId2());
//
//        // 저장된 값과 불러온 값 일치 여부
//        assertEquals(friend.getUserId1(), friend1.get().getUserId1());
//        assertEquals(friend.getUserId2(), friend1.get().getUserId2());
    }
}
