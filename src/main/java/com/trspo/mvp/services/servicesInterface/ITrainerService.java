package com.trspo.mvp.services.servicesInterface;

import com.trspo.mvp.services.entities.Trainer;
import com.trspo.mvp.services.entities.enums.SportsCategory;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ITrainerService {
    List<Trainer> getAll();
    List<Trainer> getSuitable(SportsCategory category);

    Trainer saveTrainer(Trainer trainer);

    Trainer getById(UUID id) throws NotFoundException;

    void deleteById(UUID id);

}
