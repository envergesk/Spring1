package ru.kildeev.persist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {

    private Long id;
    private String email;
    private String username;

    public User(String username) {
        this.username = username;
    }

}
