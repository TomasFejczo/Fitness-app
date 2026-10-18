package com.fitapp.repository;

import com.fitapp.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
    List<Exercise> findByExerciseNameContainingIgnoreCase(String exerciseName);
    List<Exercise> findByMuscleGroupContainingIgnoreCase(String muscleGroupName);

}
