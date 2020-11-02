package com.trspo.mvp.services.servicesImpl;

import com.trspo.mvp.services.entities.Groom;
import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.entities.Vet;
import com.trspo.mvp.services.servicesInterface.ICareService;
import com.trspo.mvp.services.servicesInterface.IGroomService;
import com.trspo.mvp.services.servicesInterface.IHorseService;
import com.trspo.mvp.services.servicesInterface.IVetService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CareService implements ICareService {
    private final IHorseService horseService;
    private final IVetService vetService;
    private final IGroomService groomService;

    @Autowired
    public CareService(IHorseService horseService,IVetService vetService, IGroomService groomService){
        this.horseService = horseService;
        this.vetService = vetService;
        this.groomService = groomService;
    }


    @Override
    public void recoverHorse(UUID horseId, UUID vetId) throws NotFoundException {
        Horse horse = horseService.getById(horseId);
        Vet vet = vetService.getById(vetId);

        horse.getRecovered();
        vet.recover();
        horseService.saveHorse(horse);
        vetService.saveVet(vet);
    }

    @Override
    public void feedHorse(UUID horseId, UUID groomId) throws NotFoundException {
        Horse horse = horseService.getById(horseId);
        Groom groom = groomService.getById(groomId);

        horse.eat();
        groom.giveFood();
        horseService.saveHorse(horse);
        groomService.saveGroom(groom);
    }
}
