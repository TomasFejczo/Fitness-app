package com.fitapp.services;


import com.fitapp.entity.Exercise;
import com.fitapp.repository.ExerciseRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ExerciseService {
    private final ExerciseRepo exerciseRepo;

    public ExerciseService(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public List<Exercise> getAllExercises(){
        return exerciseRepo.findAll();
    }

    public List<Exercise> searchByName(String exerciseName){
        return exerciseRepo.findByExerciseNameContainingIgnoreCase(exerciseName);

    }

    public List<Exercise> searchByMuscleGroup(String muscleGroupName){
        return exerciseRepo.findByMuscleGroupContainingIgnoreCase(muscleGroupName);
    }
}
