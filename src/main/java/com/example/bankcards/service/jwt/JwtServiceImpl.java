package com.example.bankcards.service.jwt;

import com.example.bankcards.dto.response.UserResponse;
import com.example.bankcards.entity.Token;
import com.example.bankcards.entity.User;
import com.example.bankcards.exception.UserNotFoundException;
import com.example.bankcards.repository.TokenRepository;
import com.example.bankcards.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class JwtServiceImpl implements JwtService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final TokenRepository tokenRepository;

    @Override
    public UserResponse generateToken(User user) {
        String accessToken = jwtProvider.generateAccessToken(user);
        String refreshToken = jwtProvider.generateRefreshToken(user);
        saveToken(user.getUsername(), refreshToken);
        return null;
    }

    @Override
    public UserResponse regenerateToken(String token) {
        String username = jwtProvider.extractAllClaims(token).getSubject();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found" + username));
        return generateToken(user);
    }

    private void saveToken(String username, String token) {
        tokenRepository.save(new Token(username, token));
    }
}
