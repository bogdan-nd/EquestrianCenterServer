package com.trspo.mvp.services.servicesImpl;

import com.trspo.mvp.services.entities.Groom;
import com.trspo.mvp.services.repositories.GroomRepository;
import com.trspo.mvp.services.servicesInterface.IGroomService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GroomService implements IGroomService {
    private final GroomRepository repository;

    @Override
    public List<Groom> getAll() {
        return repository.findAll();
    }

    @Override
    public Groom saveGroom(Groom groom) {
        return repository.save(groom);
    }

    @Override
    public Groom getById(UUID id) throws NotFoundException {
        Optional<Groom> groom = repository.findById(id);
        if (groom.isPresent())
            return groom.get();
        else
            throw new NotFoundException(String.format("Groom with %s id does not exist",id));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
