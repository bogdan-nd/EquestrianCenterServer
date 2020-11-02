package com.trspo.mvp.services.entities;
import com.trspo.mvp.services.entities.enums.HorsemanStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;



@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @JoinColumn(name="client_id")
    private UUID ownerId;
    private HorsemanStatus horsemanStatus;
    private boolean isIll;
    private LocalDateTime lastTimeEat;
    private int price;

    public Horse(String name, UUID ownerId, HorsemanStatus horsemanStatus, int price){
        this.id = UUID.randomUUID();
        this.name = name;
        this.ownerId = ownerId;
        this.horsemanStatus = horsemanStatus;
        this.isIll = false;
        this.lastTimeEat = LocalDateTime.now().withNano(0);
        this.price = price;
    }

    public void eat(){
        this.lastTimeEat = LocalDateTime.now().withNano(0);
    }

    public void getRecovered(){
        this.isIll = false;
    }
    @Override
    public String toString() {
        return String.format("\nHorse: name - %s, for %ss", name, horsemanStatus);
    }
};



