package com.aquarescue.service;

import com.aquarescue.dto.UsuarioDTO;
import com.aquarescue.model.Comunidade;
import com.aquarescue.model.Usuario;
import com.aquarescue.repository.ComunidadeRepository;
import com.aquarescue.repository.UsuarioRepository;
import com.aquarescue.security.UsuarioConfig;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioConfig usuarioConfig;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ComunidadeRepository comunidadeRepository;

    UsuarioService(UsuarioConfig usuarioConfig) {
        this.usuarioConfig = usuarioConfig;
    }

    @Transactional
    public Usuario cadastrar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setTipo(dto.getTipo());

        if (usuario.getTipo().equals("ONG")) {
            List<Comunidade> todas = comunidadeRepository.findAll();
            usuario.setComunidades(todas);
        } else {
            usuario.setComunidades(new ArrayList<>());
        }

        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public Usuario atualizar(Long id, UsuarioDTO dto) {
        Usuario usuario = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setTipo(dto.getTipo());

        if (usuario.getTipo().equals("ONG")) {
            List<Comunidade> todas = comunidadeRepository.findAll();
            usuario.setComunidades(todas);
        }

        return repository.save(usuario);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

