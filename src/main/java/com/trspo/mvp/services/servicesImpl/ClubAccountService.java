package com.trspo.mvp.services.servicesImpl;


import com.trspo.mvp.services.entities.ClubAccount;
import com.trspo.mvp.services.repositories.ClubAccountRepository;
import com.trspo.mvp.services.servicesInterface.IClubAccountService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@Service
public class ClubAccountService implements IClubAccountService {
    private final ClubAccountRepository repository;

    @Autowired
    public ClubAccountService(ClubAccountRepository repository){
        this.repository = repository;
    }

    @Override
    public ClubAccount saveClubAccount(ClubAccount clubAccount) {
        return repository.save(clubAccount);
    }

    @Override
    public ClubAccount addClubAccount(ClubAccount clubAccount) throws InstanceAlreadyExistsException {
        List<ClubAccount> clubs = repository.findAll();
        if (clubs.size() != 0)
            throw new InstanceAlreadyExistsException("Club Account already exist");
        return repository.save(clubAccount);

    }

    @Override
    public ClubAccount getAccount(){
        List<ClubAccount> clubs = repository.findAll();
        if (clubs.size() == 0)
            return null;
        return clubs.get(0);
    }
}
