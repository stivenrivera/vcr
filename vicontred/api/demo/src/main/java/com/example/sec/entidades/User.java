package com.example.sec.entidades;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(schema = "dbusers", name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 255)
    private String user;

    @Column(name = "reg_security")
    private String regSecurity;


    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getRegSecurity() { return regSecurity; }
    public void setRegSecurity(String regSecurity) { this.regSecurity = regSecurity; }

}


