package com.aquarescue.service;

import com.aquarescue.dto.DadosMeteorologicosDTO;
import com.aquarescue.model.Comunidade;
import com.aquarescue.model.DadosMeteorologicos;
import com.aquarescue.repository.ComunidadeRepository;
import com.aquarescue.repository.DadosMeteorologicosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosMeteorologicosService {

    @Autowired
    private DadosMeteorologicosRepository repository;

    @Autowired
    private ComunidadeRepository comunidadeRepository;

    @Transactional
    public DadosMeteorologicos cadastrar(DadosMeteorologicosDTO dto) {
        Comunidade comunidade = comunidadeRepository.findById(dto.getComunidadeId())
            .orElseThrow(() -> new RuntimeException("Comunidade não encontrada"));

        DadosMeteorologicos dados = DadosMeteorologicos.builder()
            .comunidade(comunidade)
            .dataHora(dto.getDataHora())
            .temperatura(dto.getTemperatura())
            .umidade(dto.getUmidade())
            .pontoOrvalho(dto.getPtoOrvalho())
            .pressao(dto.getPressao())
            .ventoVelocidade(dto.getVentoVeloc())
            .ventoDirecao(dto.getVentoDirecao())
            .ventoRajada(dto.getVentoRajada())
            .radiacao(dto.getRadiacao())
            .chuva(dto.getChuva())
            .build();

        return repository.save(dados);
    }

    public List<DadosMeteorologicos> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public DadosMeteorologicos atualizar(Long id, DadosMeteorologicosDTO dto) {
        DadosMeteorologicos dados = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Registro não encontrado"));

        dados.setDataHora(dto.getDataHora());
        dados.setTemperatura(dto.getTemperatura());
        dados.setUmidade(dto.getUmidade());
        dados.setPontoOrvalho(dto.getPtoOrvalho());
        dados.setPressao(dto.getPressao());
        dados.setVentoVelocidade(dto.getVentoVeloc());
        dados.setVentoDirecao(dto.getVentoDirecao());
        dados.setVentoRajada(dto.getVentoRajada());
        dados.setRadiacao(dto.getRadiacao());
        dados.setChuva(dto.getChuva());

        return repository.save(dados);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
