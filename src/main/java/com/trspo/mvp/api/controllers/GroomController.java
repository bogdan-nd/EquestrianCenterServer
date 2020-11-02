package com.trspo.mvp.api.controllers;

import com.trspo.mvp.api.dto.GroomDTO;
import com.trspo.mvp.services.entities.Groom;
import com.trspo.mvp.services.servicesInterface.IGroomService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("grooms")
@AllArgsConstructor
public class GroomController {
    private final IGroomService groomService;

    @GetMapping
    public ResponseEntity<List<Groom>> showGrooms() {
        return ResponseEntity.ok(groomService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Groom> showGroomById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(groomService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Groom> addGroom(@RequestBody GroomDTO groomDTO) {
        Groom newGroom = new Groom(groomDTO.getName(), groomDTO.getSalary(),
                groomDTO.getCarePrice());

        return ResponseEntity.ok(groomService.saveGroom(newGroom));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGroom(@PathVariable UUID id){
        groomService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
