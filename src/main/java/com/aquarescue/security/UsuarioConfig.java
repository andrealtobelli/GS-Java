package com.aquarescue.security;

import com.aquarescue.model.Usuario;
import com.aquarescue.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UsuarioConfig {

    @Autowired
    private UsuarioRepository repository;

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            Usuario usuario = repository.findByEmail(email);
            if (usuario == null) {
                throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
            }

            return User.builder()
                    .username(usuario.getEmail())
                    .password(usuario.getSenha()) // senha já deve estar criptografada
                    .roles(usuario.getTipo().toUpperCase()) // exemplo: LOCAL, ONG, ADMIN
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
