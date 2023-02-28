package eolebeole.bemealmap.domain.user;

import eolebeole.bemealmap.domain.entity.User;
import eolebeole.bemealmap.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //    CRUD가 구현되어 있는 UserRepository를 생성
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(int userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
