package eolebeole.bemealmap.domain.guestbook;

import eolebeole.bemealmap.domain.entity.GuestBook;
import eolebeole.bemealmap.domain.repository.GuestBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class GuestBookService {
    @Autowired
    private GuestBookRepository guestBookRepository;

    public GuestBook addGuestBook(int userId, int guestId, String content) {
        long currentTime = System.currentTimeMillis();
        Timestamp createdAt = new Timestamp(currentTime - currentTime % 1000);
        GuestBook guestBook = GuestBook.builder()
                .userId(userId)
                .guestId(guestId)
                .content(content)
                .createdAt(createdAt)
                .build();
        return guestBookRepository.save(guestBook);
    }

    public void deleteGuestBook(GuestBook guestBook) {
        guestBookRepository.delete(guestBook);
    }

    public List<GuestBook> getGuestBooks(int userId) {
        return guestBookRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public GuestBook addLike(GuestBook guestBook) {
        guestBook.setLike(guestBook.getLike() + 1);
        return guestBookRepository.save(guestBook);
    }
}
