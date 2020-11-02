package com.trspo.mvp.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.trspo.mvp.services.entities.enums.HorsemanStatus;
import lombok.Data;

import java.util.UUID;

@Data
public final class HorseDTO {
    @NotNull(message = "Name field is required")
    private final String name;
    private final UUID ownerId;
    @NotNull(message = "Horseman status field is required")
    private final HorsemanStatus horsemanStatus;

    @Positive(message = "Price must be positive")
    private final int price;

}
