package com.api.tweteroo.repositories;

import com.api.tweteroo.models.User;
import com.api.tweteroo.response.TweetResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("SELECT u.username as username, u.avatar as avatar, t.tweet as tweet " +
            "FROM Tweet t " +
            "JOIN User u ON u.id = t.user.id " +
            "WHERE u.id = :user_id " +
            "ORDER BY t.id DESC")
    List<TweetResponse> findAllTweets(@Param("user_id") Long user_id);
}
