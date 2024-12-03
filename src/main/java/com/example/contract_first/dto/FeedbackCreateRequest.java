package com.example.contract_first.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FeedbackCreateRequest(
        @NotBlank(message = "Message не может быть пустым")
        String message,

        @NotNull(message = "ID не может быть путсым")
        UUID userId
) {
}
