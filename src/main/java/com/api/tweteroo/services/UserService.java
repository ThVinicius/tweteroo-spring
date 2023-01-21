package com.api.tweteroo.services;

import com.api.tweteroo.dto.UserDTO;
import com.api.tweteroo.models.UserModel;
import com.api.tweteroo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void add(UserDTO userDTO) {
        Optional<UserModel> user = repository.findByUsername(userDTO.username());

        if (user.isEmpty()) {
            repository.save(new UserModel(userDTO));
        }


    }
}
