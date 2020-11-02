package com.trspo.mvp.services.repositories;

import com.trspo.mvp.services.entities.Groom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroomRepository extends JpaRepository<Groom, UUID> {
}
