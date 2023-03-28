package eolebeole.bemealmap.domain.guestbook;

import eolebeole.bemealmap.domain.entity.GuestBook;
import eolebeole.bemealmap.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class GuestBookController {
    @Autowired
    private GuestBookService guestBookService;

    @PostMapping("/users/{userId}/guestbooks")
    public ResponseEntity<GuestBook> addGuestBook(@PathVariable int userId, @RequestBody GuestBook guestBook, HttpSession session) {
        User user = User.builder().userId(1).build();
        guestBook = guestBookService.addGuestBook(userId, user.getUserId(), guestBook.getContent());
        return ResponseEntity.ok(guestBook);
    }

    @GetMapping("/users/{userId}/guestbooks")
    public ResponseEntity<List<GuestBook>> getGuestBooks(@PathVariable int userId) {
        List<GuestBook> guestBooks = guestBookService.getGuestBooks(userId);
        return ResponseEntity.ok(guestBooks);
    }
}
