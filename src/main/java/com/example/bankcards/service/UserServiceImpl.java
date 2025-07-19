package com.example.bankcards.service;

import com.example.bankcards.dto.UserResponse;
import com.example.bankcards.entity.User;
import com.example.bankcards.exception.UserNotFoundException;
import com.example.bankcards.repository.UserRepository;
import com.example.bankcards.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> {return new UserNotFoundException(username);});
        return user;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserResponse getUserById(long id) {
        User user = findById(id);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(long id) {
        log.debug("Deleting user: {}", id);
        userRepository.deleteById(id);
        log.debug("Deleted user: {}", id);
    }

    @Override
    public void banUserByIds(long id) {
        log.debug("Banning user: {}", id);
        User user = findById(id);
        user.setIsBanned(true);
        userRepository.save(user);
        log.debug("Banned user: {}", id);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found" + id));
    }
}