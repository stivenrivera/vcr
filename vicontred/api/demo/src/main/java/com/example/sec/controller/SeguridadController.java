package com.example.sec.controladores;

import com.example.sec.entidades.Seguridad;
import com.example.sec.servicios.SeguridadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguridad")
public class SeguridadController {

    private final SeguridadService seguridadService;

    public SeguridadController(SeguridadService seguridadService) {
        this.seguridadService = seguridadService;
    }

    @GetMapping
    public List<Seguridad> listarTodas() {
        return seguridadService.obtenerTodas();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Seguridad> obtenerPorDni(@PathVariable String dni) {
        return seguridadService.obtenerPorDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Seguridad crear(@RequestBody Seguridad seguridad) {
        return seguridadService.guardar(seguridad);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> eliminar(@PathVariable String dni) {
        seguridadService.eliminar(dni);
        return ResponseEntity.noContent().build();
    }
}

