package com.example.sec.controller;

import com.example.sec.entidades.Empresa;
import com.example.sec.service.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

    @PostMapping
    public Empresa registrar(@RequestBody Empresa empresa) {
        return service.guardar(empresa);
    }

    @GetMapping
    public List<Empresa> listar() {
        return service.listar();
    }
}
