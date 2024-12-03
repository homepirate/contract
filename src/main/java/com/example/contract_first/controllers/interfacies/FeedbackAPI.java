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
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "feedback")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успещная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class))),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",  content =
        @Content(mediaType = "application/json", schema = @Schema(implementation = StatusResponse.class)))
})
public interface FeedbackAPI {
    @Operation(summary = "Получить все")
    @GetMapping(value = "/api/feedback", produces = MediaType.APPLICATION_JSON_VALUE)
    CollectionModel<EntityModel<FeedbackResponse>> getAllFeedback();


    @Operation(summary = "Получить отзыв по ID")
    @GetMapping(value = "/api/feedback/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<FeedbackResponse> getFeedbackById(@PathVariable("id") UUID id);


    @Operation(summary = "Добавить отзыв")
    @PostMapping(value = "/api/feedback", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<FeedbackResponse> createFeedback(@Valid @RequestBody FeedbackCreateRequest request);


    @Operation(summary = "Создать назначение")
    @PutMapping(value = "/api/feedback", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<FeedbackResponse> setAssignment(@Valid @RequestBody SetAssignmentRequest request);


    @Operation(summary = "Создать назначение")
    @PutMapping(value = "/api/feedback/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<FeedbackResponse> changeStatus(@PathVariable("id") UUID id, @RequestParam String status);
}
