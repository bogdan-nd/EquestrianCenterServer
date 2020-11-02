package com.trspo.mvp.api.dto;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TrainingDTO {
    @NotNull(message = "Trainer field is required")
    private final UUID trainerId;
    @NotNull(message = "Horse field is required")
    private final UUID horseId;
    @NotNull(message = "Client field is required")
    private final UUID clientId;
    @NotNull(message = "Start Time field is required")
    private final LocalDateTime startTime;
}
