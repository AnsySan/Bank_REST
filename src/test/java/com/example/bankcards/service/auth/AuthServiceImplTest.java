package com.example.bankcards.service.auth;

import com.example.bankcards.dto.request.LoginRequest;
import com.example.bankcards.dto.request.RegistrationRequestDto;
import com.example.bankcards.dto.response.TokenResponse;
import com.example.bankcards.dto.response.UserResponse;
import com.example.bankcards.entity.User;
import com.example.bankcards.entity.enums.Role;
import com.example.bankcards.repository.TokenRepository;
import com.example.bankcards.repository.UserRepository;
import com.example.bankcards.service.authentication.AuthenticationServiceImpl;
import com.example.bankcards.service.jwt.JwtService;
import com.example.bankcards.service.user.UserService;
import com.example.bankcards.util.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock private UserService userService;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private AuthenticationManager authenticationManager;
    @Mock private JwtService jwtService;
    @Mock private UserRepository userRepository;
    @Mock private TokenRepository tokenRepository;
    @Mock private UserMapper userMapper;

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    private User user;
    private TokenResponse tokenResponse;
    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(1L)
                .username("testuser")
                .password("encodedPassword")
                .email("test@example.com")
                .role(Role.USER)
                .build();

        tokenResponse = new TokenResponse("accessToken", "refreshToken", 1L);
        userResponse = new UserResponse();
        userResponse.setId(1L);
        userResponse.setUsername("testuser");
    }

    @Test
    void login_ShouldReturnToken_WhenCredentialsAreValid() {
        LoginRequest loginRequest = new LoginRequest("testuser", "password");

        when(userService.loadUserByUsername("testuser")).thenReturn(user);
        when(jwtService.generateToken(user)).thenReturn(tokenResponse);

        TokenResponse result = authenticationService.login(loginRequest);

        verify(authenticationManager).authenticate(
                new UsernamePasswordAuthenticationToken("testuser", "password")
        );

        assertThat(result).isEqualTo(tokenResponse);
    }

    @Test
    void registration_ShouldSaveUserAndReturnResponse() {
        RegistrationRequestDto dto = new RegistrationRequestDto();
        dto.setUsername("newuser");
        dto.setPassword("password");
        dto.setEmail("new@example.com");

        String encodedPassword = "encodedPassword";
        when(passwordEncoder.encode("password")).thenReturn(encodedPassword);
        when(userMapper.toDto(any(User.class))).thenReturn(userResponse);

        UserResponse result = authenticationService.registration(dto);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userCaptor.capture());

        User savedUser = userCaptor.getValue();
        assertThat(savedUser.getUsername()).isEqualTo("newuser");
        assertThat(savedUser.getEmail()).isEqualTo("new@example.com");
        assertThat(savedUser.getPassword()).isEqualTo(encodedPassword);
        assertThat(savedUser.getRole()).isEqualTo(Role.USER);

        assertThat(result).isEqualTo(userResponse);
    }

    @Test
    void refreshToken_ShouldCallJwtServiceAndReturnNewToken() {
        String oldToken = "refreshToken123";
        when(jwtService.regenerateToken(oldToken)).thenReturn(tokenResponse);

        TokenResponse result = authenticationService.refreshToken(oldToken);

        assertThat(result).isEqualTo(tokenResponse);
        verify(jwtService).regenerateToken(oldToken);
    }
}