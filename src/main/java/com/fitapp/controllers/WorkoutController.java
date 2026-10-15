package com.fitapp.controllers;


import com.fitapp.WorkoutRequest;
import com.fitapp.entity.Workout;
import com.fitapp.services.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody WorkoutRequest request) {
        Workout savedWorkout = workoutService.createWorkout(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkout);
    }
  /*  @GetMapping("/{id}")
    public ResponseEntity<?> getWorkoutById(@PathVariable long id){
        Workout workout = repo.getWorkoutById(id);
        if(workout != null) {
            return new ResponseEntity<>(workout, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Cvik s ID "+id+" sa nenasiel.",HttpStatus.NOT_FOUND);
      }
    }
    @GetMapping("/name/{exerciseName}")
    public ResponseEntity<?> getWorkoutByName(@PathVariable String exerciseName){
        Workout workout = repo.getWorkoutByName(exerciseName);
        if(workout != null){
            return new ResponseEntity<>(workout, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Cvik sa nenasiel",HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout){
        Workout savedWorkout = repo.addWorkout(workout);
        return new ResponseEntity<>(savedWorkout, HttpStatus.CREATED);
    }*/
   /* @PutMapping("/{exerciseName}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable String exerciseName,@RequestBody Workout updatedWorkout){
        Workout workout = repo.updateExerciseByName(exerciseName, updatedWorkout);
        if(workout != null){
            return new ResponseEntity<>(workout, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(workout, HttpStatus.NOT_FOUND);
        }
    }*/

   /* @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean isDeleted = repo.deleteById(id);
        if(isDeleted){
            return new ResponseEntity<>("Cvik s ID "+ id + " bol uspesne vymazany", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Cvik s ID "+ id + " sa nenasiel", HttpStatus.NOT_FOUND);
        }
    }*/


}
