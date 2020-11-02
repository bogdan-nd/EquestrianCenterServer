package com.trspo.mvp.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@NoArgsConstructor
public class ClubAccountDTO {
    @NotNull(message = "Seed capital is required")
    @Positive(message = "Seed capital must be positive")
    private int seedCapital;
}
