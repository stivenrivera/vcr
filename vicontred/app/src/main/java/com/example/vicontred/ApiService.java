package com.example.vicontred;

import com.example.vicontred.model.User;
import com.example.vicontred.model.Administrador;
import com.example.vicontred.model.Equipo;
import com.example.vicontred.model.Password;
import com.example.vicontred.model.Auditoria;
import com.example.vicontred.model.Empresa;
import com.example.vicontred.model.Guardia;
import com.example.vicontred.model.Seguridad;
import com.example.vicontred.model.Localizacion;
import com.example.vicontred.model.Propietario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @POST("/api/users")
    Call<User> crearUsuario(@Body User user);

    @POST("/api/administradores")
    Call<Administrador> registrarAdministrador(@Body Administrador administrador);

    @POST("/api/equipos")
    Call<Equipo> registrarEquipo(@Body Equipo equipo);

    @POST("api/passwords")
    Call<Password> registrarPassword(@Body Password password);

    @POST("/api/auditoria")
    Call<Auditoria> registrarAuditoria(@Body Auditoria auditoria);

    @POST("/api/empresas")
    Call<Empresa> registrarEmpresa(@Body Empresa empresa);

    @POST("/api/guardias")
    Call<Guardia> registrarGuardia(@Body Guardia guardia);

    @POST("/api/seguridad")
    Call<Seguridad> registrarSeguridad(@Body Seguridad seguridad);

    @POST("/api/localizaciones")
    Call<Localizacion> registrarLocalizacion(@Body Localizacion localizacion);

    @GET("/api/localizaciones")
    Call<List<Localizacion>> getLocalizaciones();

    @POST("/api/propietarios")
    Call<Propietario> registrarPropietario(@Body Propietario propietario);
}
