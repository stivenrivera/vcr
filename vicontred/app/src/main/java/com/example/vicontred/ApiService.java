package com.example.vicontred;

import com.example.vicontred.model.User;
import com.example.vicontred.model.Administrador;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;

public interface ApiService {
    @POST("/api/users")
    Call<User> crearUsuario(@Body User user);

    @POST("/administradores")
    Call<Administrador> registrarAdministrador(@Body Administrador administrador);
}
