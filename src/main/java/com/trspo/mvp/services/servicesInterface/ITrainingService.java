package com.trspo.mvp.services.servicesInterface;

import com.trspo.mvp.services.entities.Training;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ITrainingService {
    List<Training> getAll();
    Training saveTraining(Training training);
    Training editTraining(Training training);
    Training getById(UUID id) throws NotFoundException;
    void deleteById(UUID id);

    void proveTraining(Training training) throws NotFoundException;
}
