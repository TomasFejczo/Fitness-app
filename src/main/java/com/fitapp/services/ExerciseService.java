package com.fitapp.services;


import com.fitapp.entity.Exercise;
import com.fitapp.exceptions.ResourceNotFoundExceptions;
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
        List<Exercise> exercises = exerciseRepo.findByExerciseNameContainingIgnoreCase(exerciseName);
        if(exercises.isEmpty()){
            throw new ResourceNotFoundExceptions("Pre zadany nazov" + exerciseName + "sa nenasiel cvik");
        }
        return exercises;
    }

    public List<Exercise> searchByMuscleGroup(String musleGroupName){
        return exerciseRepo.findByMuscleGroupContainingIgnoreCase(musleGroupName);
    }
}
