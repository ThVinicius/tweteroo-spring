package com.api.tweteroo.controllers;

import com.api.tweteroo.dto.TweetDTO;
import com.api.tweteroo.models.User;
import com.api.tweteroo.response.TweetResponse;
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
    public Page<TweetResponse> getAll(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
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

}
