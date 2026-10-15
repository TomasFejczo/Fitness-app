package com.fitapp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class WorkoutService {
    @Autowired
    private final WorkoutRepo serviceRepo;

    public List<Workout> getAllWorkouts(){
        return serviceRepo.findAll();
    }

    public Workout getWorkoutById(Long id){
        return serviceRepo.findById(id).orElse(null);
    }

    public Workout addWorkout(Workout workout) {
        return serviceRepo.save(workout);
    }

    public Workout updateExerciseByName(String exerciseName, Workout updateWorkout){
        Optional<Workout> optionalWorkout = serviceRepo.findByExerciseNameIgnoreCase(exerciseName.trim());
        if(optionalWorkout.isPresent()){
            Workout existingWorkout = optionalWorkout.get();

            existingWorkout.setSets(updateWorkout.getSets());
            existingWorkout.setReps(updateWorkout.getReps());
            existingWorkout.setWeight(updateWorkout.getWeight());
            return serviceRepo.save(existingWorkout);
        }
        else{
            return null;
        }
    }

    public Workout getWorkoutByName(String exerciseName) {
        return serviceRepo.findByExerciseNameIgnoreCase(exerciseName.trim()).orElse(null);
    }

    public boolean deleteById(Long id){
        if(serviceRepo.existsById(id)){
            serviceRepo.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
}
