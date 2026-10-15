package com.fitapp.repository;


import com.fitapp.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Long> {
    //Optional<Workout> findByExerciseNameIgnoreCase(String exerciseName);

}
