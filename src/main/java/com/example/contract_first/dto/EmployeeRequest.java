package com.example.contract_first.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequest(
        @NotBlank(message = "Name должен быть заполнен")
        String name,

        @NotNull(message = "Role должен быть заполнен")
        Role role
) {
}
