package com.example.contract_first.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SetAssignmentRequest(

        @NotNull(message = "ID не может быть путсым")
        UUID employeeId,

        @NotNull(message = "ID не может быть путсым")
        UUID feedbackId
) {
}
