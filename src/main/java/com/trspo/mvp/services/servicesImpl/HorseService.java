package com.trspo.mvp.services.servicesImpl;

import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.entities.enums.HorsemanStatus;
import com.trspo.mvp.services.repositories.HorseRepository;
import com.trspo.mvp.services.servicesInterface.IHorseService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HorseService implements IHorseService {
    private final HorseRepository repository;

    @Override
    public List<Horse> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Horse> findSuitable(HorsemanStatus status) {
        return repository.getSuitableHorses(status.ordinal());
    }

    @Override
    public Horse saveHorse(Horse horse) {
        return repository.save(horse);
    }

    @Override
    public Horse getById(UUID id) throws NotFoundException {
        Optional<Horse> horse =  repository.findById(id);
        if (horse.isPresent())
            return horse.get();
        else
            throw new NotFoundException(String.format("Horse with %s id doesn`t exist",id));
    }

    @Override
    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    @Override
    public List<Horse> getIllHorses() {
        return repository.getIllHorses();
    }
}
