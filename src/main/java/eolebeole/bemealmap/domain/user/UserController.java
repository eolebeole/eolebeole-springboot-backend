package eolebeole.bemealmap.domain.user;

import eolebeole.bemealmap.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId) {
        User user = userService.getUser(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping
    public void joinUser(User user) { userService.joinUser(user); }

    @DeleteMapping
    public void deleteUser(User user) { userService.deleteUser(user); }

    @PutMapping("./update")
    public void updateUser(User user) { userService.updateUser(user); }


}
