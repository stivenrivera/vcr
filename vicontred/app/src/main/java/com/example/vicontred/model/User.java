package com.example.vicontred.model;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "dbuser") // Asegúrate de usar el schema correcto
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user", nullable = false, unique = true)
    private String user;

    @Column(name = "reg_security", nullable = false)
    private String reg_security;

    // Constructor
    public User(String user, String reg_security) {
        this.user = user;
        this.reg_security = reg_security;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getReg_security() {
        return reg_security;
    }

    public void setReg_security(String reg_security) {
        this.reg_security = reg_security;
    }
}
