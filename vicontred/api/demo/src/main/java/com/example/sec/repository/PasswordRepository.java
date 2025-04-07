package com.example.sec.repositorios;

import com.example.sec.entidades.Passwords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Passwords, Long> {
    
}

