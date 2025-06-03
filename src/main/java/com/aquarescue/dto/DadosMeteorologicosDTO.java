package com.aquarescue.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosMeteorologicosDTO {
    @NotNull
    private Long comunidadeId;

    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    private Double temperatura;

    @NotNull
    private Double umidade;

    @NotNull
    private Double ptoOrvalho;

    @NotNull
    private Double pressao;

    @NotNull
    private Double ventoVeloc;

    @NotNull
    private Double ventoDirecao;

    @NotNull
    private Double ventoRajada;

    @NotNull
    private Double radiacao;

    @NotNull
    private Double chuva;

    public Long getComunidadeId() {
        return comunidadeId;
    }

    public void setComunidadeId(Long comunidadeId) {
        this.comunidadeId = comunidadeId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    public Double getPtoOrvalho() {
        return ptoOrvalho;
    }

    public void setPtoOrvalho(Double ptoOrvalho) {
        this.ptoOrvalho = ptoOrvalho;
    }

    public Double getPressao() {
        return pressao;
    }

    public void setPressao(Double pressao) {
        this.pressao = pressao;
    }

    public Double getVentoVeloc() {
        return ventoVeloc;
    }

    public void setVentoVeloc(Double ventoVeloc) {
        this.ventoVeloc = ventoVeloc;
    }

    public Double getVentoDirecao() {
        return ventoDirecao;
    }

    public void setVentoDirecao(Double ventoDirecao) {
        this.ventoDirecao = ventoDirecao;
    }

    public Double getVentoRajada() {
        return ventoRajada;
    }

    public void setVentoRajada(Double ventoRajada) {
        this.ventoRajada = ventoRajada;
    }

    public Double getRadiacao() {
        return radiacao;
    }

    public void setRadiacao(Double radiacao) {
        this.radiacao = radiacao;
    }

    public Double getChuva() {
        return chuva;
    }

    public void setChuva(Double chuva) {
        this.chuva = chuva;
    }
}
