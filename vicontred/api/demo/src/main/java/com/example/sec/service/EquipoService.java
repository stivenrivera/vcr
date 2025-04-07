package com.example.sec.service;

import com.example.sec.entidades.Equipo;
import com.example.sec.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    // Método para guardar un equipo
    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    // Método para obtener todos los equipos
    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }
}

