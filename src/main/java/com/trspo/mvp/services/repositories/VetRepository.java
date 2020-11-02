package com.trspo.mvp.services.repositories;

import com.trspo.mvp.services.entities.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VetRepository extends JpaRepository<Vet, UUID> {
}
