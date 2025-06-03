package com.aquarescue.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_AQUA_LOG_CALCULO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogCalculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COMUNIDADE_ID")
    private Comunidade comunidade;

    @Column(name = "DATA_CALCULO")
    private LocalDateTime dataCalculo;

    @Column(name = "QT_HABITANTES")
    private Integer qtHabitantes;

    @Column(name = "CONSUMO_POR_PESSOA")
    private Double consumoPorPessoa;

    @Column(name = "TOTAL_VOLUME")
    private Double totalVolume;
}
