package eolebeole.bemealmap.domain;

import eolebeole.bemealmap.domain.friend.FriendService;
import eolebeole.bemealmap.domain.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FriendRepositoryTests {
    @Autowired
    private FriendRepository friendRepository;

//    @Test
//    void testInsert() {
//        Friend friend = new Friend();
//        // 값 저장
//        friend.setUserId1(1);
//        friend.setUserId2(2);
//        friend.setDate((Date)formatter);
//        friendRepository.save(friend);
//
//        // 값 불러오기
//        Optional<Friend> friend1 = friendRepository.findById(friend.getUserId1());
//        Optional<Friend> friend2 = friendRepository.findById(friend.getUserId2());
//
//        // 저장된 값과 불러온 값 일치 여부
//        assertEquals(friend.getUserId1(), friend1.get().getUserId1());
//        assertEquals(friend.getUserId2(), friend1.get().getUserId2());
//    }
}
