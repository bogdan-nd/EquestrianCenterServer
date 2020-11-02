package com.trspo.mvp.services.servicesInterface;

import com.trspo.mvp.services.entities.ClubAccount;
import javassist.NotFoundException;

import javax.management.InstanceAlreadyExistsException;

public interface IClubAccountService {
    ClubAccount saveClubAccount(ClubAccount clubAccount);
    ClubAccount addClubAccount(ClubAccount clubAccount) throws InstanceAlreadyExistsException;

    ClubAccount getAccount();
}
