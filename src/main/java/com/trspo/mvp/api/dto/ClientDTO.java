package com.trspo.mvp.api.dto;

import com.trspo.mvp.services.entities.enums.HorsemanStatus;
import com.trspo.mvp.services.entities.enums.SportsCategory;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClientDTO {
    @NotNull(message = "Name field is required")
    private final String name;
    @NotNull(message = "Sports Category field is required")
    private final SportsCategory sportsCategory;
    @NotNull(message = "Horseman Status field is required")
    private final HorsemanStatus horsemanStatus;

}
