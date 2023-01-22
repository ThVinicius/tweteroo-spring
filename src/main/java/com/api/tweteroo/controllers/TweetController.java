package com.api.tweteroo.controllers;

import com.api.tweteroo.dto.request.TweetDTO;
import com.api.tweteroo.dto.response.UserTweet;
import com.api.tweteroo.models.User;
import com.api.tweteroo.services.TweetService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetController {

    private final TweetService service;

    public TweetController(TweetService service) {

        this.service = service;
    }

    @GetMapping
    public Page<UserTweet> getAll(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid TweetDTO req) {
        Optional<User> userOptional = service.findByUsername(req.username());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        service.save(req, userOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{username}")
    public ResponseEntity<List<UserTweet>> getByUsername(@PathVariable String username) {
        Optional<User> userOptional = service.findByUsername(username);

        return userOptional.map(user -> ResponseEntity.ok().body(service.findAllByUsername(user.getId())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
