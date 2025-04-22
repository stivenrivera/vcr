package com.example.vicontred.model;

import javax.persistence.*;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "user", schema = "dbuser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String user;

    @Column(name = "reg_security", nullable = false)
    private String reg_security;

    @Column(name = "tipo_user")
    @SerializedName("tipo_user")
    private String tipo_user;

    public User(String user, String reg_security) {
        this.user = user;
        this.reg_security = reg_security;
    }

    // Constructor
    public User(String user, String reg_security, String tipo_user) {
        this.user = user;
        this.reg_security = reg_security;
        this.tipo_user = tipo_user;
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

    public String getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(String tipo_user) {
        this.tipo_user = tipo_user;
    }
}
