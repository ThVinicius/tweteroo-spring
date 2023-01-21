package com.api.tweteroo.repositories;

import com.api.tweteroo.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
