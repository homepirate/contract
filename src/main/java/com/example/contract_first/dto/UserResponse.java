package com.example.contract_first.dto;

import java.util.List;
import java.util.UUID;

public record UserResponse(
         UUID id,
         String name,
         String email,
         List<FeedbackResponse>feedbacks
) {
}
