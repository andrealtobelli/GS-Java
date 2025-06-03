package com.aquarescue.repository;

import com.aquarescue.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    Usuario findByEmail(String email);
    Usuario findByEmailAndSenha(String email, String senha);
    List<Usuario> findByTipoIn(List<String> tipos);

}
