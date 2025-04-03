package com.example.vicontred.dbprocesos;

import com.example.vicontred.tablas.dbtablasAdmin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface tbAdminServices {

    @GET("..usuarios/")
    Call<List<dbtablasAdmin>> getAdmins();
}
