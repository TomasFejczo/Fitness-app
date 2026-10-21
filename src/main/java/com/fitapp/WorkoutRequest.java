package com.fitapp;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WorkoutRequest {
    @NotNull(message = "Musíš zadať ID cviku")
    private Long exerciseId;
    @NotNull(message = "Váha musí byť zadaná")
    @Positive(message = "Váha musí byť väčšia ako 0")
    @Max(value = 500, message = "Maximálna povolená váha je 500kg")
    private Double weight;
    @NotNull(message = "Počet sérií musí byť zadaný")
    @Min(value = 1,message = "Minimálny počet sérií je 1")
    private int sets;
    @NotNull(message = "Počet opakovaní musí byť zadaný")
    @Min(value = 1, message = "Minimálny počet opakovaní je 1")
    private int reps;
    private LocalDate date;
}
