package ru.itis.gymflexrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.gymflexrest.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
