package com.fitapp.controllers;


import com.fitapp.entity.Exercise;
import com.fitapp.entity.Workout;
import com.fitapp.repository.ExerciseRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseRepo exerciseRepo;

    public ExerciseController(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    @GetMapping
    public List<Exercise> getAllExercise(){

        return exerciseRepo.findAll();
    }
}
