package com.sahubrothers.repository;

import com.sahubrothers.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< User,Integer> {
    User findByUserName(String username);
}
