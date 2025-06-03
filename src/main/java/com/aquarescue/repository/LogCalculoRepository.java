package com.aquarescue.repository;

import com.aquarescue.model.LogCalculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogCalculoRepository extends JpaRepository<LogCalculo, Long> {
}
