package com.api.tweteroo.repositories;

import com.api.tweteroo.models.Tweet;
import com.api.tweteroo.response.TweetResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query("SELECT u.username as username, u.avatar as avatar, t.tweet as tweet " +
            "FROM Tweet t " +
            "JOIN User u ON u.id = t.user.id")
    Page<TweetResponse> findAllWithPagination(Pageable pageable);

}
