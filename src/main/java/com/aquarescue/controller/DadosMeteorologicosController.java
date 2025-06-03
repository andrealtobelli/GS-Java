package com.aquarescue.controller;

import com.aquarescue.dto.DadosMeteorologicosDTO;
import com.aquarescue.model.DadosMeteorologicos;
import com.aquarescue.service.DadosMeteorologicosService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-meteorologicos")
public class DadosMeteorologicosController {

    @Autowired
    private DadosMeteorologicosService service;

    @PostMapping
    public ResponseEntity<DadosMeteorologicos> cadastrar(@RequestBody @Valid DadosMeteorologicosDTO dto) {
        DadosMeteorologicos dados = service.cadastrar(dto);
        return ResponseEntity.ok(dados);
    }

    @GetMapping
    public ResponseEntity<List<DadosMeteorologicos>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosMeteorologicos> atualizar(@PathVariable Long id, @RequestBody DadosMeteorologicosDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
