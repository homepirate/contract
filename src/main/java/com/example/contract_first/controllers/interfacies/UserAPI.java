package com.example.contract_first.controllers.interfacies;

import com.example.contract_first.dto.*;
import com.example.contract_first.exception.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "user")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успещная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "404", description = "Пользователь не найден",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
})
public interface UserAPI {

    @Operation(summary = "Получить все")
    @GetMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CollectionModel<EntityModel<UserResponse>>> getAllUsers();


    @Operation(summary = "Получить пользователя по ID")
    @GetMapping(value = "/api/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<UserResponse>> getUserById(@PathVariable("id") UUID id);


    @Operation(summary = "Добавить пользователя")
    @PostMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<UserResponse>> createUser(@Valid @RequestBody UserRequest request);


    @Operation(summary = "Изменить email пользователя")
    @PutMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<UserResponse>>  updateUserEmail(@Valid @RequestBody UserUpdateRequest request);


    @Operation(summary = "Удалить пользователя")
    @ApiResponse(responseCode = "204", description = "Пользователь успешно удален")
    @DeleteMapping(value = "/api/users/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") UUID id);
}
