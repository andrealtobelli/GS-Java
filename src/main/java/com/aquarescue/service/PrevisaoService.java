package com.aquarescue.service;

import com.aquarescue.dto.PrevisaoDTO;
import com.aquarescue.model.Comunidade;
import com.aquarescue.model.Previsao;
import com.aquarescue.model.Usuario;
import com.aquarescue.repository.ComunidadeRepository;
import com.aquarescue.repository.PrevisaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class PrevisaoService {

    @Autowired
    private PrevisaoRepository repository;

    @Autowired
    private ComunidadeRepository comunidadeRepository;

    @Transactional
    public Previsao cadastrar(PrevisaoDTO dto, Usuario usuarioLogado) {
        Comunidade comunidade = comunidadeRepository.findById(dto.getComunidadeId())
            .orElseThrow(() -> new RuntimeException("Comunidade não encontrada"));

        Previsao previsao = Previsao.builder()
            .comunidade(comunidade)
            .temperatura(dto.getTemperatura())
            .umidade(dto.getUmidade())
            .volumePrevisto(dto.getVolumePrevisto())
            .dataPrevisao(dto.getDataPrevisao())
            .build();

        return repository.save(previsao);
    }

    public List<Previsao> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public Previsao atualizar(Long id, PrevisaoDTO dto) {
        Previsao previsao = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Registro não encontrado"));

        previsao.setTemperatura(dto.getTemperatura());
        previsao.setUmidade(dto.getUmidade());
        previsao.setVolumePrevisto(dto.getVolumePrevisto());
        previsao.setDataPrevisao(dto.getDataPrevisao());

        return repository.save(previsao);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}