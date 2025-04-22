package com.example.sec.controller;

import com.example.sec.entidades.Guardia;
import com.example.sec.service.GuardiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardias")
public class GuardiaController {

    @Autowired
    private GuardiaService guardiaService;

    @GetMapping
    public List<Guardia> obtenerGuardias() {
        return guardiaService.obtenerTodosLosGuardias();
    }


    @PostMapping
    public Guardia registrarGuardia(@RequestBody Guardia guardia) {
        return guardiaService.registrarGuardia(guardia);
    }
}


