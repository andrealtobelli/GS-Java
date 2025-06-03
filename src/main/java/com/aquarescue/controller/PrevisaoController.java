package com.aquarescue.controller;

import com.aquarescue.dto.PrevisaoDTO;
import com.aquarescue.model.Previsao;
import com.aquarescue.service.PrevisaoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.aquarescue.model.Usuario;

@RestController
@RequestMapping("/previsoes")
public class PrevisaoController {

    @Autowired
    private PrevisaoService service;

    @PostMapping
    public ResponseEntity<Previsao> cadastrar(
            @RequestBody @Valid PrevisaoDTO dto,
            @AuthenticationPrincipal Usuario usuarioLogado) {
        return ResponseEntity.ok(service.cadastrar(dto, usuarioLogado));
    }

    @GetMapping
    public ResponseEntity<List<Previsao>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Previsao> atualizar(@PathVariable Long id, @RequestBody PrevisaoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
