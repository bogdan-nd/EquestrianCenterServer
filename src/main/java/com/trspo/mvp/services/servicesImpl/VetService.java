package com.trspo.mvp.services.servicesImpl;

import com.trspo.mvp.services.entities.Vet;
import com.trspo.mvp.services.repositories.VetRepository;
import com.trspo.mvp.services.servicesInterface.IVetService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VetService implements IVetService {
    private final VetRepository repository;

    @Override
    public List<Vet> getAll() {
        return repository.findAll();
    }

    @Override
    public Vet saveVet(Vet vet) {
        return repository.save(vet);
    }

    @Override
    public Vet getById(UUID id) throws NotFoundException {
        Optional<Vet> vet = repository.findById(id);
        if(vet.isPresent())
            return vet.get();
        else
            throw new NotFoundException(String.format("Vet with %s id doesn`t exist",id));
    }

    @Override
    public void deleteById(UUID id){
        repository.deleteById(id);
    }
}
