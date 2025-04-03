package com.example.vicontred.model;

import javax.persistence.*;

@Entity
@Table(name = "administrador", schema = "db_empresa") // Schema de la tabla administrador
public class Administrador {

    @Id
    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    @Column(name = "primer_nombre", length = 50)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 50)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 50)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 50)
    private String segundoApellido;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "mail", length = 50)
    private String mail;

    // Relación con la tabla User
    @OneToOne(mappedBy = "administrador", cascade = CascadeType.ALL)
    private User user;

    public Administrador() {
    }

    public Administrador(String dni, String primerNombre, String segundoNombre,
            String primerApellido, String segundoApellido, String telefono, String mail) {
        this.dni = dni;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.mail = mail;
    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

}
