package com.example.sec.servicios;

import com.example.sec.entidades.Localizacion;
import com.example.sec.repositorios.LocalizacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacionService {

    private final LocalizacionRepository localizacionRepository;

    public LocalizacionService(LocalizacionRepository localizacionRepository) {
        this.localizacionRepository = localizacionRepository;
    }

    public Localizacion guardar(Localizacion localizacion) {
        return localizacionRepository.save(localizacion);
    }

    public List<Localizacion> obtenerTodas() {
        return localizacionRepository.findAll();
    }
}

