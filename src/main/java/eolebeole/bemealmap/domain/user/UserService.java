package eolebeole.bemealmap.domain.user;

import eolebeole.bemealmap.domain.entity.Token;
import eolebeole.bemealmap.domain.entity.User;
import eolebeole.bemealmap.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // CRUD가 구현되어 있는 UserRepository를 생성
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Token loginUser(User user) {
//        System.out.println(user);
        User foundUser = userRepository.findByEmail(user.getEmail());
//        System.out.println(foundUser);

        if (foundUser == null || !foundUser.getPwd().equals(user.getPwd())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return tokenService.createToken(foundUser);
    }

    public void joinUser(User user) {
        System.out.println(user);
        if ( user.getUserId() > 0 ) {
            throw new IllegalArgumentException(user.toString());
        }
        userRepository.save(user);
    }

    public void updateUser(User user) { userRepository.save(user); }

    public void deleteUser(User user) { userRepository.delete(user); }
}
