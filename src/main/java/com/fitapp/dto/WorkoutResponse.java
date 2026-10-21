package com.fitapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class WorkoutResponse {
    private Long id;
    private String exerciseName;
    private String muslceGroup;
    private Double weight;
    private int sets;
    private int reps;
    private LocalDate date;

}
