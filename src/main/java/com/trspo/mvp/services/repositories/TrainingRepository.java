package com.trspo.mvp.services.repositories;

import com.trspo.mvp.services.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainingRepository extends JpaRepository<Training, UUID> {
}
