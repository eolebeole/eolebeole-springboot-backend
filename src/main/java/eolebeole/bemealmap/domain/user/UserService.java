package eolebeole.bemealmap.domain.user;

import eolebeole.bemealmap.domain.entity.User;
import eolebeole.bemealmap.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
