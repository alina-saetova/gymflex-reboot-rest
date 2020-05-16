package ru.itis.gymflexrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.gymflexrest.models.Exercise;

import java.util.Optional;

public interface ExercisesRepository extends JpaRepository<Exercise, Long> {

    Optional<Exercise> findById(Long id);
}
