package com.example.sec.servicios;

import com.example.sec.entidades.Seguridad;
import com.example.sec.repositorios.SeguridadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguridadService {

    private final SeguridadRepository seguridadRepository;

    public SeguridadService(SeguridadRepository seguridadRepository) {
        this.seguridadRepository = seguridadRepository;
    }

    public List<Seguridad> obtenerTodas() {
        return seguridadRepository.findAll();
    }

    public Optional<Seguridad> obtenerPorDni(String dni) {
        return seguridadRepository.findById(dni);
    }

    public Seguridad guardar(Seguridad seguridad) {
        return seguridadRepository.save(seguridad);
    }

    public void eliminar(String dni) {
        seguridadRepository.deleteById(dni);
    }
}
