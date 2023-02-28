package eolebeole.bemealmap.domain.friend;

import eolebeole.bemealmap.domain.entity.Friend;
import eolebeole.bemealmap.domain.entity.User;
import eolebeole.bemealmap.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @PostMapping("/{userId}")
    public ResponseEntity<Friend> addFriend(@PathVariable Integer userId, HttpSession session) {
//        Object obj = session.getAttribute("user");
//        if (obj == null){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        User user = (User)obj;
        User user = User.builder().userId(1).build(); // TODO: 로그인 구현
        Friend friend = friendService.addFriend(user.getUserId(), userId);
        return ResponseEntity.status(HttpStatus.OK).body(friend);
    }

    @GetMapping
    public ResponseEntity<List<Friend>> getAllFriend(HttpSession session) {
        Object obj = session.getAttribute("user");
        if (obj == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = (User)obj;
        List<Friend> friendList = friendService.getAllFriends(user.getUserId());
        return ResponseEntity.status(HttpStatus.OK).body(friendList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Friend> getFriend(@PathVariable Integer userId, HttpSession session) {
//        Object obj = session.getAttribute("user");
//        if (obj == null){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        User user = (User)obj;
        User user = User.builder().userId(1).build(); // TODO: 로그인 구현
        Friend friend = friendService.getFriend(user.getUserId(), userId);
        if (friend == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(friend);
    }
}
