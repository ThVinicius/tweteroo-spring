package com.api.tweteroo.controllers;

import com.api.tweteroo.dto.TweetDTO;
import com.api.tweteroo.models.User;
import com.api.tweteroo.services.TweetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetController {

    private final TweetService service;

    public TweetController(TweetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid TweetDTO req) {
        Optional<User> userOptional = service.findByUsername(req.username());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        service.save(req, userOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
