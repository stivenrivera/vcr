package com.example.sec.service;

import com.example.sec.entidades.Administrador;
import com.example.sec.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> obtenerTodos() {
        return administradorRepository.findAll();
    }
}
