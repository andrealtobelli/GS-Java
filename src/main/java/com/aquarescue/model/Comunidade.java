package com.aquarescue.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "T_AQUA_COMUNIDADE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double latitude;
    private Double longitude;

    @Column(name = "QT_HABITANTES")
    private Integer qtHabitantes;
}
