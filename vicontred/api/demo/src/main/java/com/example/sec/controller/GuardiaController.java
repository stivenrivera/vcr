package com.example.sec.controller;

import com.example.sec.entidades.Guardia;
import com.example.sec.service.GuardiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardias")
@CrossOrigin(origins = "*") // Opcional, útil para peticiones desde Android
public class GuardiaController {

    @Autowired
    private GuardiaService guardiaService;

    @GetMapping
    public List<Guardia> obtenerGuardias() {
        return guardiaService.obtenerTodosLosGuardias();
    }
}

