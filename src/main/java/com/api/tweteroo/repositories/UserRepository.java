package com.api.tweteroo.repositories;

import com.api.tweteroo.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUsername(String username);
}
