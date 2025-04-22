package com.example.sec.controladores;

import com.example.sec.entidades.Localizacion;
import com.example.sec.servicios.LocalizacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localizaciones")
public class LocalizacionController {

    private final LocalizacionService localizacionService;

    public LocalizacionController(LocalizacionService localizacionService) {
        this.localizacionService = localizacionService;
    }

    @PostMapping
    public Localizacion crearLocalizacion(@RequestBody Localizacion localizacion) {
        return localizacionService.guardar(localizacion);
    }

    @GetMapping
    public List<Localizacion> listarLocalizaciones() {
        return localizacionService.obtenerTodas();
    }
}

