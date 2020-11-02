package com.trspo.mvp.services.servicesInterface;

import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.entities.Trainer;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface IClientOffer {
    List<Horse> getSuitableHorses(UUID clientId) throws NotFoundException;
    List<Trainer> getSuitableTrainers(UUID clientId) throws NotFoundException;
}
