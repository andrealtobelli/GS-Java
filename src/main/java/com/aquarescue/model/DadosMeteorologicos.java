package com.aquarescue.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_AQUA_DADOS_METEOROLOGICOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosMeteorologicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COMUNIDADE_ID")
    private Comunidade comunidade;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    private Double temperatura;
    private Double umidade;

    @Column(name = "PTO_ORVALHO")
    private Double pontoOrvalho;

    private Double pressao;

    @Column(name = "VENTO_VELOC")
    private Double ventoVelocidade;

    @Column(name = "VENTO_DIRECAO")
    private Double ventoDirecao;

    @Column(name = "VENTO_RAJADA")
    private Double ventoRajada;

    private Double radiacao;
    private Double chuva;
}
