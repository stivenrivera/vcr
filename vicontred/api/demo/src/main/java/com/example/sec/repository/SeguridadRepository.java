package com.example.sec.repositorios;

import com.example.sec.entidades.Seguridad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguridadRepository extends JpaRepository<Seguridad, String> {
    // Puedes agregar métodos personalizados si los necesitas
}
