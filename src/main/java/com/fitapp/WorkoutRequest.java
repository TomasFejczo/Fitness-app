package com.fitapp;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutRequest {
    private long exerciseId;
    private Double weight;
    private int sets;
    private int reps;
}
