package com.fitapp.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutUpdateRequest {
    @Min(value = 1,message = "Minimalny pocet serii je 1")
    private int sets;
    @Min(value = 1,message = "Minimalny pocet opakovani je 1")
    private int reps;
    @NotNull(message = "Váha musí byť zadaná")
    @Positive(message = "Váha musí byť väčšia ako 0")
    @Max(value = 500, message = "Maximálna povolená váha je 500kg")
    private double weight;
}
