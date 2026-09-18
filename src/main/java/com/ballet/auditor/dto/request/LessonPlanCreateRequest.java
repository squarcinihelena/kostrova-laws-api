package com.ballet.auditor.dto.request;

import com.ballet.auditor.model.enums.TermPeriod;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class LessonPlanCreateRequest {
    @NotNull(message = "O ID da turma é obrigatório")
    private Long classId;

    @NotNull(message = "O período bimestral é obrigatório")
    private TermPeriod bimonthPeriod;

    @NotEmpty(message = "O plano deve conter pelo menos um exercício")
    private List<PlanItemRequest> items;
}