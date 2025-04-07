package com.example.sec.controller;

import com.example.sec.entidades.Equipo;
import com.example.sec.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*")
public class EquipoController {

    private final EquipoService equipoService;

    @Autowired
    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    // Endpoint para registrar un equipo
    @PostMapping
    public ResponseEntity<Equipo> registrarEquipo(@RequestBody Equipo equipo) {
        try {
            Equipo equipoGuardado = equipoService.guardarEquipo(equipo);
            return new ResponseEntity<>(equipoGuardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para obtener todos los equipos
    @GetMapping
    public ResponseEntity<List<Equipo>> obtenerEquipos() {
        try {
            List<Equipo> equipos = equipoService.obtenerTodosLosEquipos();
            return new ResponseEntity<>(equipos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


