package ru.itis.gymflexrest.dto;

import lombok.Data;

@Data
public class SignInDto {
    private String email;
    private String password;
}
