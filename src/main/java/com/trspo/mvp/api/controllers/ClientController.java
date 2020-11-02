package com.trspo.mvp.api.controllers;

import com.trspo.mvp.api.dto.ClientDTO;
import com.trspo.mvp.services.entities.Client;
import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.entities.Trainer;
import com.trspo.mvp.services.servicesInterface.IClientOffer;
import com.trspo.mvp.services.servicesInterface.IClientService;
import com.trspo.mvp.services.servicesInterface.IHorseService;
import com.trspo.mvp.services.servicesInterface.ITrainerService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {
    private final IClientService clientService;
    private final IClientOffer clientOffer;

    @GetMapping
    public ResponseEntity<List<Client>> showClients() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> showClientById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(clientService.getById(id));
    }

    @GetMapping("{clientId}/possible-horses")
    public ResponseEntity<List<Horse>> getPossibleHorses(@PathVariable UUID clientId) throws NotFoundException {
        return ResponseEntity.ok(clientOffer.getSuitableHorses(clientId));
    }

    @GetMapping("{clientId}/possible-trainers")
    public ResponseEntity<List<Trainer>> getPossibleTrainers(@PathVariable UUID clientId) throws NotFoundException {
        return ResponseEntity.ok(clientOffer.getSuitableTrainers(clientId));
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody ClientDTO clientDTO) {
        Client newClient = new Client(clientDTO.getName(), clientDTO.getSportsCategory(),
                clientDTO.getHorsemanStatus());

        return ResponseEntity.ok(clientService.saveClient(newClient));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id){
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
