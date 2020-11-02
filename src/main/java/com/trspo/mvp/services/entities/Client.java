package com.trspo.mvp.services.entities;


import com.trspo.mvp.services.entities.enums.HorsemanStatus;
import com.trspo.mvp.services.entities.enums.SportsCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    private UUID id;
    private String name;
    private int creditMoney;
    private SportsCategory sportCategory;
    private HorsemanStatus horsemanStatus;

    public Client(String name, SportsCategory sportCategory, HorsemanStatus horsemanStatus){
        this.id = UUID.randomUUID();
        this.name = name;
        this.creditMoney = 0;
        this.sportCategory = sportCategory;
        this.horsemanStatus = horsemanStatus;
    }

    public void spendMoney(int moneyAmount){
        creditMoney += moneyAmount;
    }

    public boolean sameClient(Client secondClient){
        return id.equals(secondClient.id);
    }
}
