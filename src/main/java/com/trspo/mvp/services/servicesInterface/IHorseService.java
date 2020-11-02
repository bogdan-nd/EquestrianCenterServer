package com.trspo.mvp.services.servicesInterface;
import com.trspo.mvp.services.entities.enums.HorsemanStatus;

import com.trspo.mvp.services.entities.Horse;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface IHorseService {
    List<Horse> findAll();
    List<Horse> findSuitable(HorsemanStatus status);

    Horse saveHorse(Horse horse);

    Horse getById(UUID id) throws NotFoundException;

    void deleteById(UUID id);

    List<Horse> getIllHorses();

}
