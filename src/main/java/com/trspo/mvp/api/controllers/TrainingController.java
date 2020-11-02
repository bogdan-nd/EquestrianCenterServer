package com.trspo.mvp.api.controllers;

import com.trspo.mvp.api.dto.TrainingDTO;
import com.trspo.mvp.services.entities.Client;
import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.entities.Trainer;
import com.trspo.mvp.services.entities.Training;
import com.trspo.mvp.services.servicesInterface.*;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("trainings")
@AllArgsConstructor
public class TrainingController {
    private final ITrainingService trainingService;
    private final ITrainerService trainerService;
    private final IHorseService horseService;
    private final IClientService clientService;

    @GetMapping
    public ResponseEntity<List<Training>> showTrainings() {
        return ResponseEntity.ok(trainingService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Training> showTrainingById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(trainingService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addTraining(@RequestBody TrainingDTO trainingDTO){
        try{
            Trainer trainer = trainerService.getById(trainingDTO.getTrainerId());
            Horse horse = horseService.getById(trainingDTO.getHorseId());
            Client client = clientService.getById(trainingDTO.getClientId());

            Training newTraining = new Training(trainer, horse, client, trainingDTO.getStartTime());

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(trainingService.saveTraining(newTraining));
        }
        catch (NotFoundException exception){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable UUID id){
        trainingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
