package com.trspo.mvp.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class CareDTO {
    @NotNull(message = "Horse ID field is required")
    private UUID horseId;
    @NotNull(message = "Specialist ID field is required")
    private UUID specialistId;
}
