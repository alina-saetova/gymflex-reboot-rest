package ru.itis.gymflexrest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.gymflexrest.models.UserDto;
import ru.itis.gymflexrest.security.jwt.details.UserDetailsImpl;

@RestController
public class ProfileController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/self")
    public ResponseEntity<UserDto> getSelf() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();
        return ResponseEntity.ok(UserDto.builder()
                .login(userDetails.getUsername())
                .id(userDetails.getUserId())
                .build());
    }
}
