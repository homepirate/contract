package com.example.contract_first.dto;



import java.util.UUID;

public record AssignmentResponse(
        UUID id,
        UUID feedbackId,
        UUID employerId
) {
}
