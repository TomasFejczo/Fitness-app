package com.fitapp;

import com.fitapp.entity.Exercise;
import com.fitapp.repository.ExerciseRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInit implements CommandLineRunner {

    private final ExerciseRepo exerciseRepo;

    public DataInit(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if(exerciseRepo.count() == 0){
            exerciseRepo.save(new Exercise("Benchpress", "Hrudnik"));
            exerciseRepo.save(new Exercise("Drepy", "Nohy"));
            exerciseRepo.save(new Exercise("Mrtvy tah", "Chrbat"));
            System.out.println("Zakladne cviky boli pridane do databazy");

        }
    }
}
