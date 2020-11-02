package com.trspo.mvp.services.servicesImpl;

import com.trspo.mvp.services.entities.Client;
import com.trspo.mvp.services.repositories.ClientRepository;
import com.trspo.mvp.services.servicesInterface.IClientService;
import com.trspo.mvp.services.servicesInterface.IHorseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService implements IClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client getById(UUID id) throws NotFoundException {
        Optional<Client> client = repository.findById(id);
        if(client.isPresent())
            return client.get();
        else
            throw new NotFoundException(String.format("Client with %s id doesn`t exist",id));
    }


    @Override
    public void deleteById(UUID id){
        repository.deleteById(id);
    }
}
