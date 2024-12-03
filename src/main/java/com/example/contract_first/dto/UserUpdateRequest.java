package com.example.contract_first.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserUpdateRequest(
        @NotNull(message = "ID должен быть указан")
        UUID id,

        @Email(message = "Введите валидный email")
        String email
) {
}
