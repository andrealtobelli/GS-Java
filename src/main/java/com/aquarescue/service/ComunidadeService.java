package com.aquarescue.service;

import com.aquarescue.dto.ComunidadeDTO;
import com.aquarescue.model.Comunidade;
import com.aquarescue.model.Usuario;
import com.aquarescue.repository.ComunidadeRepository;
import com.aquarescue.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunidadeService {

    @Autowired
    private ComunidadeRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Comunidade cadastrar(ComunidadeDTO dto) {
        Comunidade comunidade = Comunidade.builder()
                .nome(dto.getNome())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .qtHabitantes(dto.getQtHabitantes())
                .build();
        Comunidade nova = repository.save(comunidade);

        // Vincular a todos os usuários ONG e COMUNIDADE
        List<Usuario> usuarios = usuarioRepository.findByTipoIn(List.of("ONG", "COMUNIDADE"));
        for (Usuario u : usuarios) {
            u.getComunidades().add(nova);
            usuarioRepository.save(u);
        }

        return nova;
    }

    public List<Comunidade> listarTodas() {
        return repository.findAll();
    }

    @Transactional
    public Comunidade atualizar(Long id, ComunidadeDTO dto) {
        Comunidade comunidade = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Comunidade não encontrada"));

        comunidade.setNome(dto.getNome());
        comunidade.setLatitude(dto.getLatitude());
        comunidade.setLongitude(dto.getLongitude());
        comunidade.setQtHabitantes(dto.getQtHabitantes());

        return repository.save(comunidade);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}