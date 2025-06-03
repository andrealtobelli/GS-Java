package com.aquarescue.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "T_AQUA_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "T_AQUA_USUARIO_COMUNIDADE",
        joinColumns = @JoinColumn(name = "USUARIO_ID"),
        inverseJoinColumns = @JoinColumn(name = "COMUNIDADE_ID")
    )
    private List<Comunidade> comunidades;

    private String nome;
    private String email;
    private String senha;
    private String tipo;
}
