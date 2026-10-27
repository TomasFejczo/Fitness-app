package com.fitapp;

import com.fitapp.dto.WorkoutResponse;
import com.fitapp.dto.WorkoutUpdateRequest;
import com.fitapp.entity.Exercise;
import com.fitapp.entity.User;
import com.fitapp.entity.Workout;
import com.fitapp.exceptions.ResourceNotFoundException;
import com.fitapp.services.WorkoutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.fitapp.repository.WorkoutRepo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.postgresql.hostchooser.HostRequirement.any;

@ExtendWith(MockitoExtension.class)
class ApplicationTests {

	@Mock
	private WorkoutRepo workoutRepo;

	@InjectMocks
	private WorkoutService workoutService;

	private Workout sampleWorkout;
	private WorkoutUpdateRequest workoutUpdateRequest;

	@BeforeEach
	void setUp(){
		User user = new User();
		user.setUsername("testuser");

		Exercise exercise = new Exercise();
		exercise.setId(1L);
		exercise.setExerciseName("Benchpress");
		exercise.setMuscleGroup("Hrudnik");

		sampleWorkout = new Workout();
		sampleWorkout.setId(10L);
		sampleWorkout.setUser(user);
		sampleWorkout.setExercise(exercise);
		sampleWorkout.setSets(3);
		sampleWorkout.setReps(8);
		sampleWorkout.setWeight(80.0);

		workoutUpdateRequest = new WorkoutUpdateRequest();
		workoutUpdateRequest.setSets(4);
		workoutUpdateRequest.setReps(7);
		workoutUpdateRequest.setWeight(75.0);
	}

	@Test
	@DisplayName("workoutUpdateWorkout by mal uspesne aktualizovat sets, reps a weight")
	void updateWorkout_Success(){
		when(workoutRepo.findByIdAndUserUsername(10L,"testuser"))
				.thenReturn(Optional.of(sampleWorkout));
		when(workoutRepo.save(any(Workout.class)))
				.thenAnswer(invocation -> invocation.getArgument(0));

		WorkoutResponse workoutResponse = workoutService.updateWorkout(10L,workoutUpdateRequest,"testuser");

		assertNotNull(workoutResponse);
		assertEquals(4, sampleWorkout.getSets());
		assertEquals(7, sampleWorkout.getReps());
		assertEquals(75.0, sampleWorkout.getWeight());

		verify(workoutRepo, times(1))
				.save(sampleWorkout);
	}


	@Test
	@DisplayName("workoutUpdate by mal vyhodit ResourceNotFoundException, ak workout neexistuje")
	void updateWorkout_NotFound_ThrowsException(){
		when(workoutRepo.findByIdAndUserUsername(99L,"testuser"))
				.thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class, () -> {
			workoutService.updateWorkout(99L,workoutUpdateRequest,"testuser");

		});

		verify(workoutRepo,never()).save(any(Workout.class));
	}
}
