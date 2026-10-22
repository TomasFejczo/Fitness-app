package com.fitapp.repository;


import com.fitapp.entity.User;
import com.fitapp.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Long> {
    List<Workout> findByUser(User user);

}
