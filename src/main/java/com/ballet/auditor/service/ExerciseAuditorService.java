package com.ballet.auditor.service;

import com.ballet.auditor.model.AuditReport;
import com.ballet.auditor.model.ExerciseCatalog;
import com.ballet.auditor.model.LessonPlan;
import com.ballet.auditor.model.PlanItem;
import com.ballet.auditor.model.enums.ExerciseBlock;
import com.ballet.auditor.model.enums.ImpactLevel;
import com.ballet.auditor.model.enums.RiskLevel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseAuditorService {

    public AuditReport auditPlan(LessonPlan plan) {
        List<PlanItem> items = plan.getItems();
        List<String> avisos = new ArrayList<>();
        RiskLevel nivelRisco = RiskLevel.LOW;

        if (items == null || items.isEmpty()) {
            return AuditReport.builder()
                    .lessonPlan(plan)
                    .riskLevel(RiskLevel.LOW)
                    .feedback("Plano de aula sem exercicios cadastrados.")
                    .auditedAt(LocalDateTime.now())
                    .build();
        }

        //começar na barra
        ExerciseCatalog primeiroExercicio = items.get(0).getExercise();
        if (primeiroExercicio.getBlock() != ExerciseBlock.BARRE) {
            avisos.add("Risco Estrutural: A aula deve obrigatoriamente iniciar com aquecimento e alinhamento na Barra antes de ir ao Centro ou Saltos.");
            nivelRisco = RiskLevel.HIGH;
        }

        //saltos consecutivos
        int saltosSeguidos = 0;
        for (int i = 0; i < items.size(); i++) {
            ExerciseCatalog atual = items.get(i).getExercise();

            if (atual.getImpactLevel() == ImpactLevel.HIGH) {
                saltosSeguidos++;
                if (saltosSeguidos >= 3) {
                    avisos.add("Risco de Sobrecarga por Adjacência: Sequência excessiva de saltos de alto impacto consecutivos sem descanso articular (" + atual.getName() + "). Risco de estresse no tendão calcâneo.");
                    nivelRisco = RiskLevel.HIGH;
                }
            } else {
                saltosSeguidos = 0; //zera se ex de menor impacto
            }
        }

        //sobrecarga de panturrilha
        long contagemPanturrilha = items.stream()
                .filter(item -> item.getExercise().getTargetMuscle().contains("Tríceps Sural"))
                .count();

        double densidade = (double) contagemPanturrilha / items.size();
        if (densidade > 0.60 && items.size() >= 5) {
            avisos.add("Risco por Densidade Muscular: Mais de 60% dos exercícios recrutam predominantemente o Tríceps Sural. Risco de fadiga precoce e perda de estabilidade no tálus.");
            if (nivelRisco != RiskLevel.HIGH) {
                nivelRisco = RiskLevel.MODERATE;
            }
        }

        //feedback
        String parecerFinal;
        if (avisos.isEmpty()) {
            parecerFinal = "Plano aprovado biomecanicamente! Sequência respeita o aquecimento progressivo, alternância muscular e limites articulares de impacto do 1º ano.";
        } else {
            parecerFinal = String.join(" | ", avisos);
        }

        return AuditReport.builder()
                .lessonPlan(plan)
                .riskLevel(nivelRisco)
                .feedback(parecerFinal)
                .auditedAt(LocalDateTime.now())
                .build();
    }
}