package com.trspo.mvp.api.controllers;

import com.trspo.mvp.api.dto.ClubAccountDTO;
import com.trspo.mvp.services.entities.ClubAccount;
import com.trspo.mvp.services.servicesInterface.IClubAccountService;
import com.trspo.mvp.services.servicesInterface.IFinanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;


@RestController
@RequestMapping("club")
@AllArgsConstructor
public class ClubAccountController {
    private final IClubAccountService clubAccountService;
    private final IFinanceService financeService;

    @GetMapping
    public ResponseEntity<ClubAccount> getClub(){
        return ResponseEntity.ok(clubAccountService.getAccount());
    }

    @PostMapping
    public ResponseEntity<?> addClub(@RequestBody ClubAccountDTO clubAccountDTO){
        ClubAccount newClubAccount = new ClubAccount(clubAccountDTO.getSeedCapital());
        try{
            ClubAccount club = clubAccountService.addClubAccount(newClubAccount);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(club);

        } catch (InstanceAlreadyExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        }

    }

    @PostMapping("/pay-salaries")
    public ResponseEntity<String> paySalaries(){
        financeService.paySalaries();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Club paid salaries");
    }

}
