package com.trspo.mvp.api.dto;

import com.trspo.mvp.services.entities.enums.SportsCategory;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class TrainerDTO {
    @NotNull(message = "Name field is required")
    private final String name;

    @NotNull(message = "Salary field is required")
    @Positive(message = "Salary must be positive")
    private final int  salary;

    @NotNull(message = "TrainingPrice field is required")
    @Positive(message = "TrainingPrice must be positive")
    private final int trainingPrice;

    @NotNull(message = "SportCategory field is required")
    private SportsCategory sportCategory;


}
