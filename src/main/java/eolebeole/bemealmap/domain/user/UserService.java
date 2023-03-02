package eolebeole.bemealmap.domain.user;

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

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void joinUser(User user) {
        // TODO: 유저 정보 가져오고 저장

        userRepository.save(user);
    }

    public void updateUser1(User user) {
        // TODO: 유저 정보에 대한 업데이트
        user.setEmail("test@naver.com");
        user.setPwd("test1234");
        user.setName("test");
        user.setNick("test");
        user.setCode(1234);
        userRepository.save(user);
    }

//    public void updateUser2(User user) {
//        // TODO: 유저 프로필에 대한 업데이트
//        user.setNick("test");
//        user.setCode(1234);
//        user.setImgId();
//        userRepository.save(user);
//    }

    public void deleteUser(User user) {
        //TODO: 회원 삭제 및 탈퇴
    }
}
