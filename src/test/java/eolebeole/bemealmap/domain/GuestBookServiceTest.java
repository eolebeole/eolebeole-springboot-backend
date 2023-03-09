package eolebeole.bemealmap.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import eolebeole.bemealmap.domain.guestbook.GuestBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eolebeole.bemealmap.domain.entity.GuestBook;
import eolebeole.bemealmap.domain.repository.GuestBookRepository;

@SpringBootTest
public class GuestBookServiceTest {

    @Autowired
    private GuestBookService guestBookService;

    @Autowired
    private GuestBookRepository guestBookRepository;

    @Test
    public void testCreateGuestBook() {
        // Arrange
        int userId = 1;
        int guestId = 2;
        String content = "Hello, world!";

        // Act
        GuestBook resultGuestBook = guestBookService.addGuestBook(userId, guestId, content);

        // Assert
        List<GuestBook> guestBooks = guestBookRepository.findByUserIdOrderByCreatedAtDesc(userId);
        assertThat(guestBooks).contains(resultGuestBook);
    }
}