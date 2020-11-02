package com.trspo.mvp.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class GroomDTO {
    @NotNull(message = "Name field is required")
    private final String name;

    @NotNull(message = "Salary field is required")
    @Positive(message = "Salary must be positive")
    private final int  salary;

    @NotNull(message = "CarePrice field is required")
    @Positive(message = "CarePrice must be positive")
    private final int carePrice;

}
