package com.trspo.mvp.api.controllers;

import com.trspo.mvp.api.dto.VetDTO;
import com.trspo.mvp.services.entities.Vet;
import com.trspo.mvp.services.servicesInterface.IVetService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("vets")
@AllArgsConstructor
public class VetController {
    private final IVetService vetService;

    @GetMapping
    public ResponseEntity<List<Vet>> showVets() {
        return ResponseEntity.ok(vetService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Vet> showVetById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(vetService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Vet> addVet(@RequestBody VetDTO vetDTO) {
        Vet newVet = new Vet(vetDTO.getName(), vetDTO.getSalary(), vetDTO.getConsultationPrice());

        return ResponseEntity.ok(vetService.saveVet(newVet));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVet(@PathVariable UUID id){
        vetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
