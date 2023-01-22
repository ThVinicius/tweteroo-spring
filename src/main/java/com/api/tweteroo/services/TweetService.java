package com.api.tweteroo.services;

import com.api.tweteroo.dto.TweetDTO;
import com.api.tweteroo.models.Tweet;
import com.api.tweteroo.models.User;
import com.api.tweteroo.repositories.TweetRepository;
import com.api.tweteroo.repositories.UserRepository;
import com.api.tweteroo.response.TweetResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TweetService {

    private final TweetRepository repository;
    private final UserRepository userRepository;

    public TweetService(TweetRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void save(TweetDTO tweetDTO, User user) {
        Tweet tweet = new Tweet(tweetDTO, user);

        repository.save(tweet);
    }

    public Page<TweetResponse> findAll(Pageable pageable) {

        return repository.findAllWithPagination(pageable);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    public List<TweetResponse> findAllByUsername(Long user_id) {
        return userRepository.findAllTweets(user_id);
    }
}
