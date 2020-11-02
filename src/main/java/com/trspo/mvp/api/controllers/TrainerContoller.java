package com.trspo.mvp.api.controllers;

import com.trspo.mvp.api.dto.TrainerDTO;
import com.trspo.mvp.services.entities.Trainer;
import com.trspo.mvp.services.servicesInterface.ITrainerService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("trainers")
@AllArgsConstructor
public class TrainerContoller {
    private final ITrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<Trainer>> showTrainers() {
        return ResponseEntity.ok(trainerService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Trainer> showTrainerById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(trainerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Trainer> addTrainer(@RequestBody TrainerDTO trainerDTO) {
        Trainer newTrainer = new Trainer(trainerDTO.getName(), trainerDTO.getSalary(),
               trainerDTO.getSportCategory(), trainerDTO.getTrainingPrice());

        return ResponseEntity.ok(trainerService.saveTrainer(newTrainer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable UUID id){
        trainerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
