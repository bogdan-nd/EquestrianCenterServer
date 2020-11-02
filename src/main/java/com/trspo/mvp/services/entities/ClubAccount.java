package com.trspo.mvp.services.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubAccount {
    @Id
    private UUID id;
    private int moneyAmount;
    private int seedCapital;

    public ClubAccount(int seedCapital){
        this.id = UUID.randomUUID();
        this.moneyAmount = 0;
        this.seedCapital = seedCapital;
    }

    public void spendMoney(int wasteAmount){
        moneyAmount -= wasteAmount;
    }

    public void earnMoney(int earningAmount){
        moneyAmount += earningAmount;
    }

    @Override
    public String toString(){
        int earned = moneyAmount - seedCapital;

        return String.format("Equestrian Center earned %d$", earned);
    }
}

