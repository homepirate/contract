package com.example.contract_first.controllers.interfacies;


import com.example.contract_first.dto.EmployeeRequest;
import com.example.contract_first.dto.EmployeeResponse;
import com.example.contract_first.exception.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

@Tag(name = "employee")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успещная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "404", description = "Сотрудник не найден",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
})
public interface EmployeeAPI {
    @Operation(summary = "Получить все")
    @GetMapping(value = "/api/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CollectionModel<EntityModel<EmployeeResponse>>> getAllEmployees();


    @Operation(summary = "Получить сотрудника по ID")
    @GetMapping(value = "/api/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<EmployeeResponse>> getEmployeeById(@PathVariable("id") UUID id);


    @Operation(summary = "Добавить сотрудника")
    @PostMapping(value = "/api/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<EmployeeResponse>> createEmployee(@Valid @RequestBody EmployeeRequest request);


    @Operation(summary = "Изменить роль сотрудника")
    @ApiResponse(responseCode = "404", description = "Сотрудник не найден",  content =
    @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
    @PutMapping(value = "/api/employees/{id}/role", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntityModel<EmployeeResponse>> changeRole(
           @Valid @PathVariable("id") UUID id,
           @Valid String role
    );


    @Operation(summary = "Удалить сотрудника")
    @ApiResponse(responseCode = "204", description = "Сотрудник успешно удален")
    @DeleteMapping(value = "/api/employees/{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable("id") UUID id);

}
