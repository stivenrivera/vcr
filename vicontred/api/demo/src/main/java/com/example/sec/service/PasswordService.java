package com.example.sec.servicios;

import com.example.sec.entidades.Passwords;
import com.example.sec.repositorios.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    public Passwords save(Passwords password) {
        return passwordRepository.save(password);
    }

    public List<Passwords> getAll() {
        return passwordRepository.findAll();
    }

    public Passwords getById(Long id) {
        return passwordRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        passwordRepository.deleteById(id);
    }
}

