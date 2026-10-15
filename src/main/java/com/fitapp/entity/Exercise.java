package com.fitapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exercise{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String exerciseName;

    public Exercise(String exerciseName, String muscleGroup) {
        this.exerciseName = exerciseName;
        this.muscleGroup = muscleGroup;
    }

    private String muscleGroup;
}
