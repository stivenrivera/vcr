package com.example.vicontred.dbprocesos;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clsUsuarios {

    //recibe una url y devuelve retrofit
    public static Retrofit getUsuarios(String URLuser){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URLuser).addConverterFactory(GsonConverterFactory.create()).build();
        // definimos retrofit, este obj recibe la url enviada y toma el resultado de modo gson create y lo crea.
        // retornamos un obj retrofit ya cargado gson
        return retrofit;

    }
}
