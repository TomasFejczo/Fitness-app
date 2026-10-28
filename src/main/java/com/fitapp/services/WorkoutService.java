package com.fitapp.services;


import com.fitapp.dto.WorkoutRequest;
import com.fitapp.dto.WorkoutResponse;
import com.fitapp.dto.WorkoutUpdateRequest;
import com.fitapp.entity.Exercise;
import com.fitapp.entity.User;
import com.fitapp.repository.ExerciseRepo;
import com.fitapp.repository.UserRepo;
import com.fitapp.repository.WorkoutRepo;
import com.fitapp.entity.Workout;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitapp.exceptions.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class WorkoutService {
    @Autowired
    private final WorkoutRepo workoutRepo;
    private final ExerciseRepo exerciseRepo;
    private final UserRepo userRepo;


    public WorkoutResponse createWorkout(WorkoutRequest request, String username){
        Exercise exercise = exerciseRepo.findById(request.getExerciseId()).orElseThrow(() -> new IllegalArgumentException("Cvik s ID " + request.getExerciseId() + " neexistuje!"));
        User user = userRepo.findByUsername(username)
                .orElseThrow(()->new ResourceNotFoundException("Pouzivatel nenajdeny: " + username));

        Workout workout = new Workout();
        workout.setExercise(exercise);
        workout.setWeight(request.getWeight());
        workout.setReps(request.getReps());
        workout.setSets(request.getSets());

        workout.setDate(request.getDate() != null ? request.getDate() : LocalDate.now());

        workout.setUser(user);

        Workout saved = workoutRepo.save(workout);

        return mapToResponse(saved);
    }
    public List<WorkoutResponse> getAllWorkouts(String name){
        User user = userRepo.findByUsername(name)
                .orElseThrow(()-> new ResourceNotFoundException("Používateľ nenájdený: " + name));
        List<Workout> workouts = workoutRepo.findByUser(user);
        return workouts.stream().map(this::mapToResponse).toList();}

    private WorkoutResponse mapToResponse(Workout workout) {
        return new WorkoutResponse(workout.getId(),
                workout.getExercise().getExerciseName(),
                workout.getExercise().getMuscleGroup(),
                workout.getWeight(),
                workout.getSets(),
                workout.getReps(),
                workout.getDate()
        );
    }

    public void deleteWorkout(Long id, String username){
        Workout workout = workoutRepo.findByIdAndUserUsername(id, username)
                .orElseThrow(()-> new ResourceNotFoundException("Trening s id " + id + " sa nenasiel"));
        workoutRepo.delete(workout);
    }

    public WorkoutResponse updateWorkout(Long id, WorkoutUpdateRequest workoutUpdateRequest, String username){
        Workout workout = workoutRepo.findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new ResourceNotFoundException("Trening s id " + id + " sa nenasiel"));
        workout.setSets(workoutUpdateRequest.getSets());
        workout.setReps(workoutUpdateRequest.getReps());
        workout.setWeight(workoutUpdateRequest.getWeight());

        Workout update = workoutRepo.save(workout);
        return mapToResponse(update);
    }
}
