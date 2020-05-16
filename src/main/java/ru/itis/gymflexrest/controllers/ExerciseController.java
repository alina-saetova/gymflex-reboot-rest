package ru.itis.gymflexrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.itis.gymflexrest.models.Exercise;
import ru.itis.gymflexrest.security.jwt.details.UserDetailsImpl;
import ru.itis.gymflexrest.services.ExerciseService;
import ru.itis.gymflexrest.services.UserFavExercisesService;

import java.util.List;

@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private UserFavExercisesService userFavExercisesService;

    @GetMapping("/exercises/{exercise-id}")
    public ResponseEntity<Exercise> getExercise(@PathVariable("exercise-id") Long exerciseId) {
        Exercise exercise = exerciseService.getConcreteExercise(exerciseId);
        return ResponseEntity.ok(exercise);
    }

    @GetMapping("/exercises")
    public ResponseEntity<List<Exercise>> getAllExercises() {
        List<Exercise> exercises = exerciseService.getAll();
        return ResponseEntity.ok(exercises);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/exercises/{exercise-id}/like")
    public ResponseEntity<Integer> like(@PathVariable("exercise-id") Long exerciseId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();
        int result = userFavExercisesService.like(exerciseId, userDetails.getUserId());
        return ResponseEntity.ok(result);
    }
}
