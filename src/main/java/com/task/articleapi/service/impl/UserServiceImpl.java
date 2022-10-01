package com.task.articleapi.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.articleapi.dto.UserDto;
import com.task.articleapi.entity.User;
import com.task.articleapi.mapper.UserEntityMapper;
import com.task.articleapi.repository.UserRepository;
import com.task.articleapi.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityMapper userEntityMapper;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @PostConstruct
    void init() {
        UserDto user = findByUsername("user");
        if (user == null) {
            User user1 = new User();
            user1.setUsername("user");
            user1.setPassword(passwordEncoder.encode("user"));
            user1.setUserType(User.UserType.USER);
            userRepository.save(user1);
        }
        UserDto admin = findByUsername("admin");
        if (admin == null) {
            User user2 = new User();
            user2.setUsername("admin");
            user2.setPassword(passwordEncoder.encode("admin"));
            user2.setUserType(User.UserType.ADMIN);
            userRepository.save(user2);
        }
    }

    @Override
    public UserDto findByUsername(String username) {
        return userEntityMapper.mapToDto(userRepository.findByUsername(username).orElse(null));
    }
}

