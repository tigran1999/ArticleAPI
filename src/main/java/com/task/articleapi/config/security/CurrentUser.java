package com.task.articleapi.config.security;

import org.springframework.security.core.authority.AuthorityUtils;

import com.task.articleapi.entity.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;


    public CurrentUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType().name()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}