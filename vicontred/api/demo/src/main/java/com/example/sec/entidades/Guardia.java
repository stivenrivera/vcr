package com.example.sec.entidades;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "guardias", schema = "db_seguridad")
public class Guardia {

    @Id
    @Column(name = "id_guardia")
    private Long idGuardia;

    @Column(name = "dni")
    private String dni;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_de_nacimiento")
    private LocalDate fechaDeNacimiento;

    @Column(name = "codigo_guardia")
    private String codigoGuardia;

    @Column(name = "record_militar")
    private String recordMilitar;

    @Column(name = "reg_auditoria")
    private String regAuditoria;

    @Column(name = "correo")
    private String correo;

    // Getters y Setters

    public Long getIdGuardia() {
        return idGuardia;
    }

    public void setIdGuardia(Long idGuardia) {
        this.idGuardia = idGuardia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCodigoGuardia() {
        return codigoGuardia;
    }

    public void setCodigoGuardia(String codigoGuardia) {
        this.codigoGuardia = codigoGuardia;
    }

    public String getRecordMilitar() {
        return recordMilitar;
    }

    public void setRecordMilitar(String recordMilitar) {
        this.recordMilitar = recordMilitar;
    }

    public String getRegAuditoria() {
        return regAuditoria;
    }

    public void setRegAuditoria(String regAuditoria) {
        this.regAuditoria = regAuditoria;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

