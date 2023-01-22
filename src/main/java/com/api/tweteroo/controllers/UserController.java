package com.api.tweteroo.controllers;

import com.api.tweteroo.dto.request.UserDTO;
import com.api.tweteroo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void add(@RequestBody @Valid UserDTO req) {
        service.add(req);
    }
}
