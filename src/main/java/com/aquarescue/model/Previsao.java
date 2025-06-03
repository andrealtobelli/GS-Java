package com.aquarescue.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_AQUA_PREVISAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Previsao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COMUNIDADE_ID")
    private Comunidade comunidade;

    private Double temperatura;
    private Double umidade;

    @Column(name = "VOLUME_PREVISTO")
    private Double volumePrevisto;

    @Column(name = "DATA_PREVISAO")
    private LocalDateTime dataPrevisao;
}
