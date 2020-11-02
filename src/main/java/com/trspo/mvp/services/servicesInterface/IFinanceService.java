package com.trspo.mvp.services.servicesInterface;

import javassist.NotFoundException;

import java.util.UUID;

public interface IFinanceService {
    void paySalaries();
    void trainingPayment(UUID trainingId) throws NotFoundException;
    void vetPayment(UUID vetId, UUID clientId) throws NotFoundException;
    void groomPayment(UUID groomId, UUID clientId) throws NotFoundException;
}
