package com.aquarescue.service;

import com.aquarescue.dto.LogCalculoDTO;
import com.aquarescue.model.Comunidade;
import com.aquarescue.model.LogCalculo;
import com.aquarescue.repository.ComunidadeRepository;
import com.aquarescue.repository.LogCalculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogCalculoService {

    @Autowired
    private LogCalculoRepository repository;

    @Autowired
    private ComunidadeRepository comunidadeRepository;

    @Transactional
    public LogCalculo cadastrar(LogCalculoDTO dto) {
        Comunidade comunidade = comunidadeRepository.findById(dto.getComunidadeId())
            .orElseThrow(() -> new RuntimeException("Comunidade não encontrada"));

        LogCalculo log = LogCalculo.builder()
            .comunidade(comunidade)
            .dataCalculo(dto.getDataCalculo())
            .qtHabitantes(dto.getQtHabitantes())
            .consumoPorPessoa(dto.getConsumoPorPessoa())
            .totalVolume(dto.getTotalVolume())
            .build();

        return repository.save(log);
    }

    public List<LogCalculo> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public LogCalculo atualizar(Long id, LogCalculoDTO dto) {
        LogCalculo log = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Registro não encontrado"));

        log.setDataCalculo(dto.getDataCalculo());
        log.setQtHabitantes(dto.getQtHabitantes());
        log.setConsumoPorPessoa(dto.getConsumoPorPessoa());
        log.setTotalVolume(dto.getTotalVolume());

        return repository.save(log);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
