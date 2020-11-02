package com.trspo.mvp.services.repositories;

import com.trspo.mvp.services.entities.ClubAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClubAccountRepository extends JpaRepository<ClubAccount, UUID> {

}
