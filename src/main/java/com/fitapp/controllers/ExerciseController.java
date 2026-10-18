package com.fitapp.controllers;


import com.fitapp.entity.Exercise;
import com.fitapp.entity.Workout;
import com.fitapp.repository.ExerciseRepo;
import com.fitapp.services.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<Exercise> getAllExercises(){
        return exerciseService.getAllExercises();
    }

    @GetMapping("/search")
    public List<Exercise> searchByName(@RequestParam String name){
        return exerciseService.searchByName(name);
    }
    @GetMapping("/muscle-group/{muscleGroup}")
    public List<Exercise> searchByMuscleGroup(@PathVariable String muscleGroup){
    return exerciseService.searchByMuscleGroup(muscleGroup);
    }
}
