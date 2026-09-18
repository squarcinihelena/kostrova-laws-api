package com.ballet.auditor.config;

import com.ballet.auditor.model.ExerciseCatalog;
import com.ballet.auditor.model.enums.ExerciseBlock;
import com.ballet.auditor.model.enums.ImpactLevel;
import com.ballet.auditor.repository.ExerciseCatalogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner seedDatabase(ExerciseCatalogRepository repository) {
        return args -> {
            if (repository.count() > 0) {
                return;
            }

            List<ExerciseCatalog> exerciciosAno1 = List.of(

                    new ExerciseCatalog(null, "Demi-Plié", 1, ExerciseBlock.BARRE,
                            "Quadríceps, Isquiotibiais, Glúteos", "Joelho", ImpactLevel.LOW,
                            "Manter patela alinhada sobre o 2º dedo do pé e peso no tripé plantar."),

                    new ExerciseCatalog(null, "Grand Plié", 1, ExerciseBlock.BARRE,
                            "Quadríceps, Isquiotibiais, Glúteos", "Joelho", ImpactLevel.MODERATE,
                            "Controle excêntrico sem desabar a articulação abaixo de 90 graus."),

                    new ExerciseCatalog(null, "Battement Tendu", 1, ExerciseBlock.BARRE,
                            "Iliopsoas, Tríceps Sural, Intrínsecos do Pé", "Tornozelo", ImpactLevel.LOW,
                            "Pé deslizando em contato contínuo com o solo com pelve neutra."),

                    new ExerciseCatalog(null, "Battement Tendu Jeté", 1, ExerciseBlock.BARRE,
                            "Iliopsoas, Quadríceps, Tríceps Sural", "Quadril", ImpactLevel.LOW,
                            "Acentuação rápida na saída mantendo o quadril estabilizado."),

                    new ExerciseCatalog(null, "Rond de Jambe à Terre", 1, ExerciseBlock.BARRE,
                            "Rotadores Externos do Quadril, Glúteo Médio", "Quadril", ImpactLevel.LOW,
                            "Isolar o fêmur no acetábulo sem torção da pelve."),

                    new ExerciseCatalog(null, "Battement Fondu", 1, ExerciseBlock.BARRE,
                            "Quadríceps, Isquiotibiais, Tríceps Sural", "Joelho", ImpactLevel.LOW,
                            "Flexão e extensão coordenadas com controle excêntrico."),

                    new ExerciseCatalog(null, "Battement Frappé", 1, ExerciseBlock.BARRE,
                            "Quadríceps, Vasto Medial, Tríceps Sural", "Joelho", ImpactLevel.LOW,
                            "Extensão rápida ativando vasto medial para proteger a patela."),

                    new ExerciseCatalog(null, "Petit Battement sur le cou-de-pied", 1, ExerciseBlock.BARRE,
                            "Tibial Anterior, Tríceps Sural", "Tornozelo", ImpactLevel.LOW,
                            "Coxa imóvel enquanto a perna articula ao redor do tornozelo."),

                    new ExerciseCatalog(null, "Battement Relevé Lent à 45°", 1, ExerciseBlock.BARRE,
                            "Iliopsoas, Reto Femoral, Abdômen", "Quadril", ImpactLevel.LOW,
                            "Subida lenta e contínua sem compensação na coluna lombar."),

                    new ExerciseCatalog(null, "Grand Battement Jeté", 1, ExerciseBlock.BARRE,
                            "Iliopsoas, Reto Femoral, Glúteos", "Quadril", ImpactLevel.MODERATE,
                            "Força explosiva controlada sem inclinar o tronco."),

                    new ExerciseCatalog(null, "Relevé sur Demi-Pointe", 1, ExerciseBlock.BARRE,
                            "Tríceps Sural, Tibial Posterior", "Tornozelo", ImpactLevel.LOW,
                            "Elevação vertical alinhando o centro do tálus."),


                    new ExerciseCatalog(null, "Port de Bras (1º, 2º e 3º)", 1, ExerciseBlock.CENTER,
                            "Deltoide, Dorsais, Trapézio Inferior", "Ombro", ImpactLevel.LOW,
                            "Estabilização escapular evitando elevação dos ombros."),

                    new ExerciseCatalog(null, "Battement Tendu en Centre", 1, ExerciseBlock.CENTER,
                            "Iliopsoas, Glúteo Médio, Tríceps Sural", "Quadril", ImpactLevel.LOW,
                            "Equilíbrio do centro de gravidade sobre a perna de base."),

                    new ExerciseCatalog(null, "Temps Lié à Terre", 1, ExerciseBlock.CENTER,
                            "Quadríceps, Glúteos, Adutores", "Quadril", ImpactLevel.LOW,
                            "Transferência contínua de peso pelo demi-plié."),


                    new ExerciseCatalog(null, "Temps Levé Sauté", 1, ExerciseBlock.ALLEGRO,
                            "Tríceps Sural, Quadríceps, Glúteos", "Tornozelo", ImpactLevel.HIGH,
                            "Amortecimento em demi-plié elástico para absorver impacto."),

                    new ExerciseCatalog(null, "Pas Échappé", 1, ExerciseBlock.ALLEGRO,
                            "Tríceps Sural, Quadríceps, Adutores", "Tornozelo", ImpactLevel.HIGH,
                            "Aterrissagem na 2ª posição com joelhos alinhados sobre os pés."),

                    new ExerciseCatalog(null, "Pas Assemblé", 1, ExerciseBlock.ALLEGRO,
                            "Tríceps Sural, Isquiotibiais, Glúteos", "Tornozelo", ImpactLevel.HIGH,
                            "União no ar em 5ª posição antes do demi-plié suave."),

                    new ExerciseCatalog(null, "Changement de Pieds", 1, ExerciseBlock.ALLEGRO,
                            "Tríceps Sural, Quadríceps, Glúteos", "Tornozelo", ImpactLevel.HIGH,
                            "Troca de pés na 5ª posição com calcanhares firmes no solo ao descer.")
            );

            repository.saveAll(exerciciosAno1);
            System.out.println("[SUCESSO] 18 Exercícios do 1º Ano Vaganova cadastrados no banco!");
        };
    }
}