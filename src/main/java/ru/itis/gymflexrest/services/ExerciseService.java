package ru.itis.gymflexrest.services;

import ru.itis.gymflexrest.models.Exercise;

import java.util.List;

public interface ExerciseService {

    List<Exercise> getAll();
    Exercise getConcreteExercise(Long id);
}
