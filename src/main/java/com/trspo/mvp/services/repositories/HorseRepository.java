package com.trspo.mvp.services.repositories;

import com.trspo.mvp.services.entities.Horse;
import com.trspo.mvp.services.entities.enums.HorsemanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.UUID;

public interface HorseRepository extends JpaRepository<Horse, UUID> {
    @Query("select horse from Horse horse where horse.isIll = true")
    List<Horse> getIllHorses();

    @Query(value = "select * from horse where horseman_status = :status", nativeQuery = true)
    List<Horse> getSuitableHorses(@Param("status") int status);

}
