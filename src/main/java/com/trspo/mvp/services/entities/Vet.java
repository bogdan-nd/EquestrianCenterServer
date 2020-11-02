package com.trspo.mvp.services.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public final class Vet{
    @Id
    private UUID id;
    private String name;
    private int salary;
    private int consultationPrice;
    private int recoveredHorsesNumber;

    public Vet(String name, int salary, int consultationPrice){
        this.id = UUID.randomUUID();
        this.name = name;
        this.salary = salary;
        this.consultationPrice = consultationPrice;
        this.recoveredHorsesNumber = 0;
    }

    public void recover(){
        recoveredHorsesNumber += 1;
    }

    @Override
    public String toString(){
        return String.format("Vet %s, consultation Price - %d$", name, consultationPrice);
    }

}
