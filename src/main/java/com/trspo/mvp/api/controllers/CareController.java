package com.trspo.mvp.api.controllers;

import com.trspo.mvp.api.dto.CareDTO;
import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.servicesInterface.ICareService;
import com.trspo.mvp.services.servicesInterface.IFinanceService;
import com.trspo.mvp.services.servicesInterface.IHorseService;
import com.trspo.mvp.services.servicesInterface.IVetService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.UUID;

@RestController
@RequestMapping(value = "care")
@AllArgsConstructor
public class CareController {
    private final IHorseService horseService;
    private final ICareService careService;
    private final IFinanceService financeService;

    @PostMapping(value = "recover")
    public ResponseEntity<String> recoverHorse(@RequestBody CareDTO appointmentDTO){
        try {
            UUID horseId = appointmentDTO.getHorseId();
            UUID vetId = appointmentDTO.getSpecialistId();

            Horse horse = horseService.getById(horseId);
            UUID ownerId = horse.getOwnerId();
            careService.recoverHorse(horseId, vetId);

            if (ownerId != null)
                financeService.vetPayment(vetId, ownerId);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Successfully created the vet appointment");
        }

        catch (NotFoundException exception){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(exception.getMessage());
        }
    }

    @PostMapping(value = "feed")
    public ResponseEntity<String> feedHorse(@RequestBody CareDTO appointmentDTO){
        try {
            UUID horseId = appointmentDTO.getHorseId();
            UUID groomId = appointmentDTO.getSpecialistId();

            Horse horse = horseService.getById(horseId);
            UUID ownerId = horse.getOwnerId();
            careService.feedHorse(horseId, groomId);

            if (ownerId != null)
                financeService.groomPayment(groomId, ownerId);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Successfully created the groom appointment");
        }

        catch (NotFoundException exception){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(exception.getMessage());
        }
    }

}
