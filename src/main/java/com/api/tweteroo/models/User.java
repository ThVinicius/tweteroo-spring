package com.api.tweteroo.models;

import com.api.tweteroo.dto.request.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String avatar;

    public User(UserDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }

}
