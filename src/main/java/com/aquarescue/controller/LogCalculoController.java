package com.aquarescue.controller;

import com.aquarescue.dto.LogCalculoDTO;
import com.aquarescue.model.LogCalculo;
import com.aquarescue.service.LogCalculoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log-calculo")
public class LogCalculoController {

    @Autowired
    private LogCalculoService service;

    @PostMapping
    public ResponseEntity<LogCalculo> cadastrar(@RequestBody @Valid LogCalculoDTO dto) {
        return ResponseEntity.ok(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<LogCalculo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogCalculo> atualizar(@PathVariable Long id, @RequestBody LogCalculoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
