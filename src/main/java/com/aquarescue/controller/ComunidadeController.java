package com.aquarescue.controller;

import com.aquarescue.dto.ComunidadeDTO;
import com.aquarescue.model.Comunidade;
import com.aquarescue.service.ComunidadeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comunidades")
public class ComunidadeController {

    @Autowired
    private ComunidadeService comunidadeService;

    @PostMapping
    public ResponseEntity<Comunidade> cadastrar(@RequestBody @Valid ComunidadeDTO dto) {
        Comunidade nova = comunidadeService.cadastrar(dto);
        return ResponseEntity.ok(nova);
    }

    @GetMapping
    public ResponseEntity<List<Comunidade>> listar() {
        return ResponseEntity.ok(comunidadeService.listarTodas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comunidade> atualizar(@PathVariable Long id, @RequestBody ComunidadeDTO dto) {
        return ResponseEntity.ok(comunidadeService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        comunidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
