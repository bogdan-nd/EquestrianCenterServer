package com.trspo.mvp.services.servicesImpl;

import com.trspo.mvp.services.entities.Trainer;

import com.trspo.mvp.services.entities.enums.SportsCategory;
import com.trspo.mvp.services.repositories.TrainerRepository;
import com.trspo.mvp.services.servicesInterface.ITrainerService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TrainerService implements ITrainerService {
    private final TrainerRepository repository;

    @Override
    public List<Trainer> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Trainer> getSuitable(SportsCategory category) {
        return repository.getSuitableTrainers(category.ordinal());
    }

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        return repository.save(trainer);
    }

    @Override
    public Trainer getById(UUID id) throws NotFoundException {
        Optional<Trainer> trainer = repository.findById(id);
        if(trainer.isPresent())
            return trainer.get();
        else
            throw new NotFoundException(String.format("Trainer with %s id doesn`t exist",id));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

}
