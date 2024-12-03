package com.example.contract_first.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "Name должен быть заполнен")
        String name,

        @Email(message = "Введите валидный email")
        String email
) {
}
