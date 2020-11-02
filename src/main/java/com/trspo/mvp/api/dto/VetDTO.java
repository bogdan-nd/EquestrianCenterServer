package com.trspo.mvp.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class VetDTO {
    @NotNull(message = "Name field is required")
    private final String name;

    @NotNull(message = "Salary field is required")
    @Positive(message = "Salary must be positive")
    private final int  salary;

    @NotNull(message = "ProductionPrice field is required")
    @Positive(message = "ProductionPrice must be positive")
    private final int consultationPrice;
}
