package com.trspo.mvp.api.controllers;

import com.trspo.mvp.api.dto.HorseDTO;
import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.servicesInterface.IHorseService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("horses")
@AllArgsConstructor
public class HorseController {
    private final IHorseService horseService;

    @GetMapping
    public ResponseEntity<List<Horse>> getHorses(){
        return ResponseEntity.ok(horseService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Horse> getHorseById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(horseService.getById(id));
    }


    @GetMapping("ill")
    public ResponseEntity<List<Horse>> getIllHorses(){
        return ResponseEntity.ok(horseService.getIllHorses());
    }

    @PostMapping
    public ResponseEntity<Horse> addHorse(@RequestBody HorseDTO horseDTO){
        Horse newHorse = new Horse(horseDTO.getName(), horseDTO.getOwnerId(),
                horseDTO.getHorsemanStatus(), horseDTO.getPrice());

        return ResponseEntity.ok(horseService.saveHorse(newHorse));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHorse(@PathVariable UUID id){
        horseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
