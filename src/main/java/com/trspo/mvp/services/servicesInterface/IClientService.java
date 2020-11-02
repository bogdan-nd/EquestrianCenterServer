package com.trspo.mvp.services.servicesInterface;

import com.trspo.mvp.services.entities.Client;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface IClientService {
    List<Client> findAll();

    Client saveClient(Client client);

    Client getById(UUID id) throws NotFoundException;
    void deleteById(UUID id);
}
