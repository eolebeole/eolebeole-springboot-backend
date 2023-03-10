package eolebeole.bemealmap.domain;

import eolebeole.bemealmap.domain.entity.User;
import eolebeole.bemealmap.domain.repository.UserRepository;
import eolebeole.bemealmap.domain.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class UserTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void testJoinUser() {
        User user = new User();

        user.setEmail("test@naver.com");
        user.setPwd("test1234");
        user.setName("test");
        user.setNick("test");
        user.setCode(9999);
        user.setGender(0);

        User user2 = userRepository.save(user);

        assertEquals(user.getEmail(), user2.getEmail());
    }
}
