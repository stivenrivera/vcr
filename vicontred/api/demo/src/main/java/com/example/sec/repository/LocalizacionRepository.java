package com.example.sec.repositorios;

import com.example.sec.entidades.Localizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacionRepository extends JpaRepository<Localizacion, Long> {
}
