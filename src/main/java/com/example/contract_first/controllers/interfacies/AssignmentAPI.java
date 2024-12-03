package com.example.contract_first.controllers.interfacies;
import com.example.contract_first.dto.AssignmentResponse;
import com.example.contract_first.exception.StatusResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Tag(name = "assignments")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успещная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
})
public interface AssignmentAPI {
    @Operation(summary = "Получить все")
    @GetMapping(value = "/api/assignments")
    CollectionModel<EntityModel<AssignmentResponse>> getAllAssignments();

    @Operation(summary = "Получить назначение по ID")
    @GetMapping(value = "/api/assignments/{id}")
    EntityModel<AssignmentResponse> getAssignmentById(@PathVariable("id") UUID id);
}
