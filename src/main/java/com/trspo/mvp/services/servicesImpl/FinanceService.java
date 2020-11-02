package com.trspo.mvp.services.servicesImpl;

import com.trspo.mvp.services.entities.*;
import com.trspo.mvp.services.servicesInterface.*;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FinanceService implements IFinanceService {
    private final IGroomService groomService;
    private final IVetService vetService;
    private final IHorseService horseService;
    private final ITrainerService trainerService;
    private final ITrainingService trainingService;
    private final IClientService clientService;
    private final IClubAccountService clubAccountService;

    @Override
    public void paySalaries(){
        List<Groom> grooms = groomService.getAll();
        List<Trainer> trainers = trainerService.getAll();
        List<Vet> vets = vetService.getAll();
        ClubAccount clubAccount = clubAccountService.getAccount();

        for(Groom groom: grooms) {
            int groomSalary = groom.getSalary();
            clubAccount.spendMoney(groomSalary);
        }

        for(Vet vet: vets){
            int vetSalary = vet.getSalary();
            clubAccount.spendMoney(vetSalary);
        }

        for(Trainer trainer: trainers){
            int trainerSalary = trainer.getSalary();
            clubAccount.spendMoney(trainerSalary);
        }

        clubAccountService.saveClubAccount(clubAccount);
    }

    @Override
    public void trainingPayment(UUID trainingId) throws NotFoundException {
        Training training = trainingService.getById(trainingId);
        Client client = training.getClient();
        Trainer trainer = training.getTrainer();
        ClubAccount account = clubAccountService.getAccount();

        int trainingPrice = trainer.getTrainingPrice();
        client.spendMoney(trainingPrice);
        account.earnMoney(trainingPrice);

        clientService.saveClient(client);
        clubAccountService.saveClubAccount(account);
    }

    @Override
    public void vetPayment(UUID vetId, UUID clientId) throws NotFoundException {
        Vet vet = vetService.getById(vetId);
        Client client = clientService.getById(clientId);
        ClubAccount account = clubAccountService.getAccount();

        int vetConsultationPrice = vet.getConsultationPrice();
        client.spendMoney(vetConsultationPrice);
        account.earnMoney(vetConsultationPrice);

        clientService.saveClient(client);
        clubAccountService.saveClubAccount(account);
    }

    @Override
    public void groomPayment(UUID groomId, UUID clientId) throws NotFoundException {
        Groom groom = groomService.getById(groomId);
        Client client = clientService.getById(clientId);
        ClubAccount account = clubAccountService.getAccount();

        int groomCarePrice = groom.getCarePrice();
        client.spendMoney(groomCarePrice);
        account.earnMoney(groomCarePrice);

        clientService.saveClient(client);
        clubAccountService.saveClubAccount(account);
    }

}
