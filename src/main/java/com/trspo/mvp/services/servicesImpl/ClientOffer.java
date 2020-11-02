package com.trspo.mvp.services.servicesImpl;

import com.trspo.mvp.services.entities.Client;
import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.entities.Trainer;
import com.trspo.mvp.services.entities.enums.HorsemanStatus;
import com.trspo.mvp.services.entities.enums.SportsCategory;
import com.trspo.mvp.services.servicesInterface.IClientOffer;
import com.trspo.mvp.services.servicesInterface.IClientService;
import com.trspo.mvp.services.servicesInterface.IHorseService;
import com.trspo.mvp.services.servicesInterface.ITrainerService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientOffer implements IClientOffer {
    private final IHorseService horseService;
    private final IClientService clientService;
    private final ITrainerService trainerService;

    @Override
    public List<Horse> getSuitableHorses(UUID clientId) throws NotFoundException {
        Client client = clientService.getById(clientId);
        HorsemanStatus clientHorsemanStatus = client.getHorsemanStatus();

        return horseService.findSuitable(clientHorsemanStatus);
    }

    @Override
    public List<Trainer> getSuitableTrainers(UUID clientId) throws NotFoundException {
        Client client = clientService.getById(clientId);
        SportsCategory clientSportCategory = client.getSportCategory();

        return trainerService.getSuitable(clientSportCategory);
    }
}
