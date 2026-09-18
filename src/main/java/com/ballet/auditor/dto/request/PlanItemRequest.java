package com.ballet.auditor.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PlanItemRequest {
    @NotNull(message = "O ID do exercício é obrigatório")
    private Long exerciseId;

    @NotNull(message = "A ordem de sequência é obrigatória")
    private Integer seqOrder;
}