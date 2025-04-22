package com.example.sec.entidades;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("reg_security")
    private String reg_security;

    @Column(name = "tipo_user")
    @JsonProperty("tipo_user")
    private String tipo_user;


    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getRegSecurity() { return reg_security; }
    public void setRegSecurity(String reg_security) { this.reg_security = reg_security; }

    public String getTipoUser() { return tipo_user; }
    public void setTipoUser(String tipo_user) { this.tipo_user = tipo_user; }

}


