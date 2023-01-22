package com.api.tweteroo.models;

import com.api.tweteroo.dto.request.TweetDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "tweets")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tweet;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Tweet(TweetDTO data, User user) {
        this.tweet = data.tweet();
        this.user = user;
    }

}
