package ru.itis.gymflexrest.services;

import ru.itis.gymflexrest.dto.SignInDto;
import ru.itis.gymflexrest.dto.TokenDto;

public interface SignInService {

    TokenDto signIn(SignInDto signInData);
}
