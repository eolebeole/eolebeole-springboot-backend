package eolebeole.bemealmap.domain.friend;

import eolebeole.bemealmap.domain.entity.Friend;
import eolebeole.bemealmap.domain.entity.FriendId;
import eolebeole.bemealmap.domain.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    public Friend addFriend(Integer userId, Integer userId2) {
        Friend friend = getFriend(userId, userId2);
        if ( friend != null ) {
            throw new IllegalArgumentException(friend.toString());
        }
        friend = Friend.builder()
                .userId1(userId)
                .userId2(userId2)
                .date(new Date())
                .build();
        friendRepository.save(friend);
        return friend;
    }

    public void deleteFriend(Integer userId1, Integer userId2) {
        friendRepository.delete(getFriend(userId1, userId2));
    }

    public List<Friend> getAllFriends(Integer userId) {
        return friendRepository.findAll().stream().filter(
                friend -> friend.getUserId1() == userId).collect(Collectors.toList());
    }

    public Friend getFriend(Integer userId, Integer userId2) {
        return friendRepository.findById(FriendId.builder()
                .userId1(userId)
                .userId2(userId2)
                .build()).orElse(null);
    }
}
