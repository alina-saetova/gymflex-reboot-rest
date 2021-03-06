package ru.itis.gymflexrest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.gymflexrest.dto.SignInDto;
import ru.itis.gymflexrest.dto.TokenDto;
import ru.itis.gymflexrest.services.SignInService;

@RestController
public class SignInController {

    @Autowired
    private SignInService signInService;

    @PostMapping("/signIn")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInDto signInDto) {
        return ResponseEntity.ok(signInService.signIn(signInDto));
    }
}
