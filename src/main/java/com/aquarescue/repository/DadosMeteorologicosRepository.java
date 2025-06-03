package com.aquarescue.repository;

import com.aquarescue.model.DadosMeteorologicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosMeteorologicosRepository extends JpaRepository<DadosMeteorologicos, Long> {
}
