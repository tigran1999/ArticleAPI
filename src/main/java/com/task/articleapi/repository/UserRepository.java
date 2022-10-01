package com.task.articleapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.articleapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
