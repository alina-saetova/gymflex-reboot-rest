package ru.itis.gymflexrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.gymflexrest.models.Exercise;
import ru.itis.gymflexrest.models.FavUserExercise;
import ru.itis.gymflexrest.repositories.ExercisesRepository;
import ru.itis.gymflexrest.repositories.UserFavExerciseRepository;

import java.util.Optional;

@Service
public class UserFavExercisesServiceImpl implements UserFavExercisesService {

    @Autowired
    private UserFavExerciseRepository userFavExerciseRepository;

    @Autowired
    private ExercisesRepository exercisesRepository;

    @Override
    public int like(Long exerciseId, Long userId) {
        userFavExerciseRepository.save(
                FavUserExercise.builder()
                        .exerciseId(exerciseId)
                        .userId(userId)
                        .build()
        );
        Optional<Exercise> optionalExercise = exercisesRepository.findById(exerciseId);
        int count = 0;
        if (optionalExercise.isPresent()) {
            Exercise exercise = optionalExercise.get();
            count = exercise.getCnt_likes() + 1;
            exercise.setCnt_likes(count);
            exercisesRepository.save(exercise);
        }
        return count;
    }
}
