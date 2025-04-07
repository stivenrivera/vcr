package com.example.sec.repository;

import com.example.sec.entidades.Guardia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardiaRepository extends JpaRepository<Guardia, Long> {
}
