package com.trspo.mvp.services.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Training {
    @Id
    private UUID id;
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "horse_id", nullable = false)
    private Horse horse;
    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    private LocalDateTime startTime;
    private int duration;

    public Training(Trainer trainer, Horse horse, Client client, LocalDateTime startTime){
        this.id = UUID.randomUUID();
        this.trainer = trainer;
        this.horse = horse;
        this.client = client;
        this.startTime = startTime;
        this.duration = 90;
    }

    @Override
    public String toString(){
        LocalDateTime endTime = startTime.plus(duration, ChronoUnit.MINUTES);

        return String.format("\nTraining %tR - %tR %tD, client - %s, trainer - %s, horse - %s",
                startTime, endTime, startTime, client.getName(), trainer.getName(), horse.getName());
    }

}
