package ru.itis.gymflexrest.services;

public interface UserFavExercisesService {

    int like(Long exerciseId, Long userId);
}
