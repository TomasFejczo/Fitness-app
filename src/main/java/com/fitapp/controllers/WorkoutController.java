package com.fitapp.controllers;


import com.fitapp.dto.WorkoutRequest;
import com.fitapp.dto.WorkoutResponse;
import com.fitapp.dto.WorkoutUpdateRequest;
import com.fitapp.services.WorkoutService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<WorkoutResponse> createWorkout(@Valid @RequestBody WorkoutRequest request,@Parameter(hidden = true) Principal principal) {
        String username = principal.getName();
        WorkoutResponse savedWorkout = workoutService.createWorkout(request, username);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkout);
    }

    @GetMapping
    public ResponseEntity<List<WorkoutResponse>> getAllWorkouts(@Parameter(hidden = true)Principal principal){
        String username = principal.getName();
        List<WorkoutResponse> workouts = workoutService.getAllWorkouts(username);
        return ResponseEntity.ok(workouts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteWorkout(@PathVariable Long id, @Parameter(hidden = true)Principal principal){
        workoutService.deleteWorkout(id, principal.getName());

        Map<String, String> response = new HashMap<>();
        response.put("message","Treningovy zaznam s ID " + id + " bol zmazany");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutResponse> updateWorkout(@PathVariable Long id,@Valid @RequestBody WorkoutUpdateRequest workoutUpdateRequest,@Valid @Parameter(hidden = true)Principal principal){
        WorkoutResponse response = workoutService.updateWorkout(id, workoutUpdateRequest, principal.getName());

        return ResponseEntity.ok(response);
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
