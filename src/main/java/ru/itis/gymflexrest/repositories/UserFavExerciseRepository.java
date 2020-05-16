package ru.itis.gymflexrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.gymflexrest.models.FavUserExercise;

public interface UserFavExerciseRepository extends JpaRepository<FavUserExercise, Long> {

}
