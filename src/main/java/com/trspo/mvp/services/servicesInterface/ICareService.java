package com.trspo.mvp.services.servicesInterface;

import javassist.NotFoundException;

import java.util.UUID;

public interface ICareService {
    void recoverHorse(UUID horseId, UUID vetId) throws NotFoundException;
    void feedHorse(UUID horseId, UUID vetId) throws NotFoundException;
}
