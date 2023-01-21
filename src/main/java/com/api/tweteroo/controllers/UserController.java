package com.api.tweteroo.controllers;

import com.api.tweteroo.dto.UserDTO;
import com.api.tweteroo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void add(@RequestBody @Valid UserDTO req){
        service.add(req);
    }
}
