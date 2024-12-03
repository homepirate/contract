package com.example.contract_first.dto;

import java.util.List;
import java.util.UUID;

public record EmployeeResponse(
        UUID id,
        String name,
        Role role,
        List<AssignmentResponse>assignments
) {
}
