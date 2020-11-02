package com.trspo.mvp.services.servicesImpl;

import com.trspo.mvp.services.entities.Client;
import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.entities.Trainer;
import com.trspo.mvp.services.entities.Training;
import com.trspo.mvp.services.entities.enums.SportsCategory;
import com.trspo.mvp.services.repositories.TrainingRepository;
import com.trspo.mvp.services.servicesInterface.ITrainingService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TrainingService implements ITrainingService {
    private final TrainingRepository repository;
    @Override
    public List<Training> getAll() {
        return repository.findAll();
    }

    @Override
    public Training saveTraining(Training training) {
        proveTraining(training);
        return repository.save(training);
    }

    @Override
    public Training editTraining(Training training) {
        return repository.saveAndFlush(training);
    }

    @Override
    public Training getById(UUID id) throws NotFoundException {
        Optional<Training> training = repository.findById(id);
        if(training.isPresent())
            return training.get();
        else
            throw new NotFoundException(String.format("Training with %s id doesn`t exist",id));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void proveTraining (Training training){
        Horse horse = training.getHorse();
        Client client = training.getClient();
        Trainer trainer = training.getTrainer();

        SportsCategory trainerStatus = trainer.getSportCategory();
        SportsCategory clientStatus = client.getSportCategory();
        boolean isClientStatusAdvanced = clientStatus.compareTo(trainerStatus) > 0;

        if(horse.getHorsemanStatus() != client.getHorsemanStatus())
            throw  new IllegalArgumentException("Horse rider`s status should be the same with client");

        else if(isClientStatusAdvanced)
            throw new IllegalArgumentException("TrainerDTO must have no less Sport Category level than client");

    }
}
