package com.example.contract_first.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FeedbackResponse(
        @NotBlank(message = "Message не может быть пустым")
        String message,

        @NotNull(message = "ID не может быть путсым")
        UUID userId,

        @NotNull(message = "ID не может быть путсым")
        UUID id,

        @NotNull(message = "ID не может быть путсым")
        UUID assignmentId,

        @NotBlank(message = "Status не может быть пустым")
        String status
) {
}
