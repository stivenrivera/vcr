package com.example.sec.entidades;

import javax.persistence.*;       
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "equipos", schema = "dbequipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long idEquipo;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "android_id")
    private String androidId;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "version_os")
    private String versionOs;

    @Column(name = "fecha_registro")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaRegistro;

    @Column(name = "imei")
    private String imei;

    @Column(name = "numero_telefono")
    private String numeroTelefono;

    // Constructor vacío
    public Equipo() {}

    // Constructor completo
    public Equipo(Long idUsuario, String androidId, String marca, String modelo,
                  String versionOs, LocalDateTime fechaRegistro, String imei, String numeroTelefono) {
        this.idUsuario = idUsuario;
        this.androidId = androidId;
        this.marca = marca;
        this.modelo = modelo;
        this.versionOs = versionOs;
        this.fechaRegistro = fechaRegistro;
        this.imei = imei;
        this.numeroTelefono = numeroTelefono;
    }

    // Getters y setters
    public Long getIdEquipo() { return idEquipo; }
    public void setIdEquipo(Long idEquipo) { this.idEquipo = idEquipo; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getAndroidId() { return androidId; }
    public void setAndroidId(String androidId) { this.androidId = androidId; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getVersionOs() { return versionOs; }
    public void setVersionOs(String versionOs) { this.versionOs = versionOs; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public String getImei() { return imei; }
    public void setImei(String imei) { this.imei = imei; }

    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }
}