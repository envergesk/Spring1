package ru.kildeev.persist;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class User {

    private Long id;
    @Email
    @NotBlank(message="cannot be empty")
    private String email;
    @NotBlank(message="cannot be empty")
    private String username;

    @Pattern(regexp = "^(?=.*?[0-9])(?=.*?[A-Z]).{8,}$", message = "Password too simple")
    private String password;

    private String matchingPassword;

    public User(String username) {
        this.username = username;
    }

}
