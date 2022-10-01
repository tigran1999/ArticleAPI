package com.task.articleapi.service;

import com.task.articleapi.dto.UserDto;

public interface UserService {
    /**
     *  get  user by username
     *
     * @param username the username
     *
     * @return userDto
     */
    UserDto findByUsername(String username);
}

