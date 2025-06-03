package com.aquarescue.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogCalculoDTO {

    @NotNull
    private Long comunidadeId;

    @NotNull
    private Integer qtHabitantes;

    @NotNull
    private Double consumoPorPessoa;

    @NotNull
    private Double totalVolume;

    @NotNull
    private LocalDateTime dataCalculo;

    public Long getComunidadeId() {
        return comunidadeId;
    }

    public void setComunidadeId(Long comunidadeId) {
        this.comunidadeId = comunidadeId;
    }

    public Integer getQtHabitantes() {
        return qtHabitantes;
    }

    public void setQtHabitantes(Integer qtHabitantes) {
        this.qtHabitantes = qtHabitantes;
    }

    public Double getConsumoPorPessoa() {
        return consumoPorPessoa;
    }

    public void setConsumoPorPessoa(Double consumoPorPessoa) {
        this.consumoPorPessoa = consumoPorPessoa;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public LocalDateTime getDataCalculo() {
        return dataCalculo;
    }

    public void setDataCalculo(LocalDateTime dataCalculo) {
        this.dataCalculo = dataCalculo;
    }
}
