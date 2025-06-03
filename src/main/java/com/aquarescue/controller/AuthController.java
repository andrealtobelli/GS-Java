package com.aquarescue.controller;

import com.aquarescue.dto.LoginDTO;
import com.aquarescue.dto.LoginResponseDTO;
import com.aquarescue.model.Usuario;
import com.aquarescue.repository.UsuarioRepository;
import com.aquarescue.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("Tentando login com: " + loginDTO.getEmail() + " / " + loginDTO.getSenha());
        Usuario usuario = usuarioRepository.findByEmailAndSenha(loginDTO.getEmail(), loginDTO.getSenha());
        if (usuario == null) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
        String token = jwtUtil.generateToken(usuario.getEmail());
        if (usuario.getTipo().equals("ONG") || usuario.getTipo().equals("COMUNIDADE")) {
            List<Long> ids = usuario.getComunidades().stream()
                .map(c -> c.getId())
                .collect(Collectors.toList());
            return ResponseEntity.ok(new LoginResponseDTO(token, ids));
        } else {
            return ResponseEntity.ok(new LoginResponseDTO(token, null));
        }
    }
}