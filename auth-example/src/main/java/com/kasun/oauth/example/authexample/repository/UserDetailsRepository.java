package com.kasun.oauth.example.authexample.repository;

import com.kasun.oauth.example.authexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String name);
}
