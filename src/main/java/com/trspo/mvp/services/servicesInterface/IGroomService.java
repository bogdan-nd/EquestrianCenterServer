package com.trspo.mvp.services.servicesInterface;

import com.trspo.mvp.services.entities.Groom;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface IGroomService {
    List<Groom> getAll();

    Groom saveGroom(Groom groom);
    Groom getById(UUID id)throws NotFoundException;
    void deleteById(UUID id);
}
