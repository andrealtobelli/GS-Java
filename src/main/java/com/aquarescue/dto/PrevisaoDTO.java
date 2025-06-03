package com.aquarescue.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrevisaoDTO {
    @NotNull
    private Long comunidadeId;

    @NotNull
    private Double temperatura;

    @NotNull
    private Double umidade;

    @NotNull
    private Double volumePrevisto;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataPrevisao;

    public Long getComunidadeId() {
        return comunidadeId;
    }

    public void setComunidadeId(Long comunidadeId) {
        this.comunidadeId = comunidadeId;
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

    public Double getVolumePrevisto() {
        return volumePrevisto;
    }

    public void setVolumePrevisto(Double volumePrevisto) {
        this.volumePrevisto = volumePrevisto;
    }

    public LocalDateTime getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(LocalDateTime dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }
}
