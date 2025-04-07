package com.example.sec.service;

import com.example.sec.entidades.Guardia;
import com.example.sec.repository.GuardiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuardiaService {

    @Autowired
    private GuardiaRepository guardiaRepository;

    public List<Guardia> obtenerTodosLosGuardias() {
        return guardiaRepository.findAll();
    }
}

