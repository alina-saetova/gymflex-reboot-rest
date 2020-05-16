package ru.itis.gymflexrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.gymflexrest.models.Exercise;
import ru.itis.gymflexrest.repositories.ExercisesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    private ExercisesRepository exercisesRepository;

    @Override
    public List<Exercise> getAll() {
        return exercisesRepository.findAll();
    }

    @Override
    public Exercise getConcreteExercise(Long id) {
        Optional<Exercise> exerciseOptional = exercisesRepository.findById(id);
        return exerciseOptional.orElse(null);
    }
}
