package com.example.sec.entidades;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "seguridad", schema = "db_seguridad")
public class Seguridad {

    @Id
    @Column(name = "dni", length = 20)
    private String dni;

    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "rep_legal")
    private String representanteLegal;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "reg_auditoria")
    private String regAuditoria;

    // Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRegAuditoria() {
        return regAuditoria;
    }

    public void setRegAuditoria(String regAuditoria) {
        this.regAuditoria = regAuditoria;
    }
}
