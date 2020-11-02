package com.trspo.mvp.services.servicesInterface;

import com.trspo.mvp.services.entities.Vet;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface IVetService {
    List<Vet> getAll();

    Vet saveVet(Vet vet);
    Vet getById(UUID id) throws NotFoundException;
    void deleteById(UUID id);
}
