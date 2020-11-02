package com.trspo.mvp.services.entities;

import com.trspo.mvp.services.entities.enums.SportsCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public final class Trainer{
    @Id
    private UUID id;
    private String name;
    private int salary;
    private SportsCategory sportCategory;
    private int trainingPrice;

    public Trainer(String name, int salary, SportsCategory sportCategory, int trainingPrice){
        this.name = name;
        this.salary = salary;
        this.id = UUID.randomUUID();
        this.sportCategory = sportCategory;
        this.trainingPrice = trainingPrice;
    }

    @Override
    public String toString(){
        return String.format("\nRough rider %s, sport category - %s, training price - %d$",
                name, sportCategory, trainingPrice);
    }
}
