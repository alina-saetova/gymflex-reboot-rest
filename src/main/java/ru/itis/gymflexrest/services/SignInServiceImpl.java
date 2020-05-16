package ru.itis.gymflexrest.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.gymflexrest.dto.SignInDto;
import ru.itis.gymflexrest.dto.TokenDto;
import ru.itis.gymflexrest.models.User;
import ru.itis.gymflexrest.repositories.UsersRepository;

import java.util.Optional;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public TokenDto signIn(SignInDto signInData) {
        Optional<User> userOptional = usersRepository.findUserByEmail(signInData.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(signInData.getPassword(), user.getPassword())) {
                String token = Jwts.builder()
                        .setSubject(user.getId().toString())
                        .claim("login", user.getLogin())
                        .claim("role", user.getRole().name())
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();
                return new TokenDto(token);
            } else throw new AccessDeniedException("Wrong email/password");
        } else throw new AccessDeniedException("User not found");
    }
}
