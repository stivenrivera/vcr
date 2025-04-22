package com.example.sec.controller;

import com.example.sec.entidades.Auditoria;
import com.example.sec.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @PostMapping
    public Auditoria registrar(@RequestBody Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    @GetMapping
    public List<Auditoria> listar() {
        return auditoriaRepository.findAll();
    }
}

