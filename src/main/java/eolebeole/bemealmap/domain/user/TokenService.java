package eolebeole.bemealmap.domain.user;

import eolebeole.bemealmap.domain.entity.Token;
import eolebeole.bemealmap.domain.entity.User;
import eolebeole.bemealmap.domain.repository.TokenRepository;
import eolebeole.bemealmap.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenService {
    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    public Token createToken(User user) {
        String value = tokenGenerator.generateToken();
        Token token = tokenRepository.findByUserUserId(user.getUserId()).orElse(Token.builder().user(user).build());
        token.setValue(value);
        tokenRepository.save(token);
        return token;
    }

    public User verifyAuthHeader(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null; // Authorization header가 존재하지 않거나 Bearer scheme으로 시작하지 않으면 null 반환
        }
        String token = authHeader.substring(7); // "Bearer " 부분을 잘라내고 남은 token 추출
        return verifyToken(token);
    }

    public User verifyToken(String tokenValue) {
        Optional<Token> token = tokenRepository.findByValue(tokenValue);
        return token.map(Token::getUser).orElse(null);
    }
}
